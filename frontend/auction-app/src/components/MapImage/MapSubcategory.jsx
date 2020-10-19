import React from 'react';
import { Image } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

import '../../styles/image/Image.scss';

const MapSubCategory = ({ data, size, url }) => {
    const history = useHistory();

    let imageSrc = null;
    if (data.photoUrl) {
        imageSrc = data.photoUrl;
    }
    
    return (
        <div className="featured-item-container">
            <Image
                className={"featured-item-image-" + size}
                src={imageSrc}
                onClick={() => history.push(url)}
            />
            <div className="prop-name">
                {data.name} Collection
            </div>
             Starts from $59.99
        </div>
    );
}

export default MapSubCategory;