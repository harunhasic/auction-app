import React from 'react';
import { Image } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';
import { isEmpty } from '../../utils/array';
import '../../styles/image/Image.scss';

const ProductCard = ({ data, size, url }) => {
    const history = useHistory();

    let imageSrc = null;
    if (!isEmpty(data.photos)) {
        imageSrc = data.photos[0].photoUrl;
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
             Starts from ${data.startPrice}
        </div>
    );
}

export default ProductCard;