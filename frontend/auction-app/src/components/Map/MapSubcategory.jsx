import React from 'react';
import { Image } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';

import '../../styles/image/Image.scss';

const SubCategoryCard = ({ data, size, url }) => {
    const history = useHistory();

    let imageSrc = null;
    if (data.photoUrl !== null) {
        imageSrc = data.photoUrl;
    }
    
    return (
        <div className="featured-item-container">
            <Image
                className={"featured-item-image-" + size}
                src={imageSrc}
                onClick={() => history.push(url)}
            />
            <div className="property-name">
                {data.name} Collection
            </div>
        </div>
    );
}

export default SubCategoryCard;