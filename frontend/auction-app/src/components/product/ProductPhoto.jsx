import React, { useState } from 'react';
import { Image, Modal } from 'react-bootstrap';
import { AiOutlineFullscreen } from "react-icons/ai";

import '../../styles/product/ProductPhoto.scss';

const ProductPhoto = ({ photos }) => {

    const [activePhoto, setActivePhoto] = useState(0);
    const [showFullscreen, setShowFullscreen] = useState(false);
    const [showFullscreenIcon, setShowFullscreenIcon] = useState(false);

    const path = photos[activePhoto] !== undefined ? photos[activePhoto].photoUrl : "undefined";
    return (
        <div className="images-container">
            <Modal size="xl" centered show={showFullscreen} onHide={() => setShowFullscreen(false)}>
                <Image onClick={() => setShowFullscreen(false)} width="100%" src={path} />
            </Modal>
            <Image
                onClick={() => setShowFullscreen(true)}
                onMouseEnter={() => setShowFullscreenIcon(true)}
                onMouseLeave={() => setShowFullscreenIcon(false)}
                key={photos[activePhoto].id}
                width="100%"
                height="438px"
                src={photos[activePhoto].photoUrl}
                className="product-image-big"
            />
            <AiOutlineFullscreen
                onMouseEnter={() => setShowFullscreenIcon(true)}
                onMouseLeave={() => setShowFullscreenIcon(false)}
                className={!showFullscreenIcon ? "fullscreen-icon-none" : "fullscreen-icon"}
                onClick={() => setShowFullscreen(true)}
            />
            {photos.map((photo, i) => (
                <Image
                    onClick={() => setActivePhoto(i)}
                    key={photo.id}
                    src={photo.photoUrl}
                    className="product-image-small"
                />
            ))}
        </div>
    );
}

export default ProductPhoto;