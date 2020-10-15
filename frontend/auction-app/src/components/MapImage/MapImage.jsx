import React from 'react';
import { Image } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

import '../../styles/image/Image.scss';

const MapImage = ({ data, size, url }) => {
    const history = useHistory();

    let imageSrc = null;
    if (data.photos && data.photos.length) {
        imageSrc = data.photos[0].photoUrl;
    }
    
    return (
        <div className="featured-item-container">
            <Image
                className={"featured-item-image-" + size}
                src={imageSrc}
                onClick={() => history.push(url)}
            />
            <h3>
                {data.name}
            </h3>
             Starts from ${data.startPrice}
        </div>
    );
}

export default MapImage;