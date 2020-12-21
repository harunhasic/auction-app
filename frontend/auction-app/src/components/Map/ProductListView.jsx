import React from 'react';
import { Button, Image } from 'react-bootstrap';
import { RiAuctionFill } from "react-icons/ri";
import { useHistory } from 'react-router-dom';
import { isEmpty } from '../../utils/array';
import '../../styles/product/ListItem.scss';

const ListCard = ({ data, url }) => {
    
    const history = useHistory();

    let imageSrc = null;
    if (!isEmpty(data.photos)) {
        imageSrc = data.photos[0].photoUrl;
    }

    return (
        <div className="list-item-container">
            <Image
                className="list-item-image"
                src={imageSrc}
                onClick={() => history.push(url)}
            />
            <div className="list-info-container">
                <h3 className="product-name" onClick={() => history.push(url)}>
                    {data.name}
                </h3>
                <div className="list-item-description">
                    {data.description}
                </div>
                <div className="featured-product-price">
                    Start from ${data.startPrice}
                </div>
                <div className="button-container">
                    <Button
                        className="bid-button"
                        variant="transparent-gray"
                        onClick={() => history.push(url)}
                    >
                        Bid
                        <RiAuctionFill className="auction-icon" />
                    </Button>
                </div>
            </div>
        </div>
    );
}

export default ListCard;