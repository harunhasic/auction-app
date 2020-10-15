import React, { useState } from 'react';
import { Image, Modal } from 'react-bootstrap';
import { AiOutlineFullscreen } from "react-icons/ai";

import '../../styles/product/ProductImages.scss';

const ProductImages = ({ photos }) => {

    const [activePhoto, setActivePhoto] = useState(0);
    const [showFullscreen, setShowFullscreen] = useState(false);
    const [showFullscreenIcon, setShowFullscreenIcon] = useState(false);

    return (
        <div className="images-container">
            <Modal size="xl" centered show={showFullscreen} onHide={() => setShowFullscreen(false)}>
                <Image onClick={() => setShowFullscreen(false)} width="100%" src={photos[activePhoto].url} />
            </Modal>
            <Image
                onClick={() => setShowFullscreen(true)}
                onMouseEnter={() => setShowFullscreenIcon(true)}
                onMouseLeave={() => setShowFullscreenIcon(false)}
                key={photos[activePhoto].id}
                width="100%"
                height="438px"
                src={photos[activePhoto].url}
                className="product-image-big"
            />
            <AiOutlineFullscreen
                onMouseEnter={() => setShowFullscreenIcon(true)}
                onMouseLeave={() => setShowFullscreenIcon(false)}
                style={!showFullscreenIcon ? { display: 'none' } : null}
                className="fullscreen-icon"
                onClick={() => setShowFullscreen(true)}
            />
            {photos.map((photo, i) => (
                <Image
                    onClick={() => setActivePhoto(i)}
                    key={photo.id}
                    src={photo.url}
                    className="product-image-small"
                    style={activePhoto === i ? { border: '2px solid #8367D8' } : { opacity: 0.7 }}
                />
            ))}
        </div>
    );
}

export default ProductImages;