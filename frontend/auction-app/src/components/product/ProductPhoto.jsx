import React, { useState } from 'react';
import { Image, Modal } from 'react-bootstrap';
import { AiOutlineFullscreen } from "react-icons/ai";

import '../../styles/product/ProductPhoto.scss';
import { isEmpty } from '../../utils/array';

const ProductPhoto = ({ photos }) => {

    const [activePhotoIndex, setActivePhotoIndex] = useState(0);
    const [showFullscreen, setShowFullscreen] = useState(false);
    const [showFullscreenIcon, setShowFullscreenIcon] = useState(false);

    const path = photos[activePhotoIndex] !== isEmpty ? photos[activePhotoIndex].photoUrl : "undefined";
    return (
        <div className="images-container">
          <Modal size="xl" centered show={showFullscreen} onHide={() => setShowFullscreen(false)}>
            <Image onClick={() => setShowFullscreen(false)} className="image-width-100" src={path} />
          </Modal>
            <Image
                onClick={() => setShowFullscreen(true)}
                onMouseEnter={() => setShowFullscreenIcon(true)}
                onMouseLeave={() => setShowFullscreenIcon(false)}
                key={photos[activePhotoIndex].id}
                src={photos[activePhotoIndex].photoUrl}
                className="product-image-big"
            />
            <AiOutlineFullscreen
                onMouseEnter={() => setShowFullscreenIcon(true)}
                onMouseLeave={() => setShowFullscreenIcon(false)}
                className={!showFullscreenIcon ? "fullscreen-icon-none" : "fullscreen-icon"}
                onClick={() => setShowFullscreen(true)}
            />
            {
              photos.map((photo, i) => (
                <Image
                    onClick={() => setActivePhotoIndex(i)}
                    key={photo.id}
                    src={photo.photoUrl}
                    className="product-image-small"
                />
              ))
            }
        </div>
    );
}

export default ProductPhoto;