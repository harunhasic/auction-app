import React, { useEffect, useState } from 'react';
import { Button } from 'react-bootstrap';
import { RiAuctionFill, RiHeartFill } from 'react-icons/ri';
import { useHistory } from 'react-router-dom';
import { checkIfTouch } from '../../utils/touch';

import '../../styles/product/ProductCardOverlay.scss';

const ProductCardOverlay = ({ children, data, url }) => {
    const history = useHistory();

    const [visible, setVisible] = useState(false);

 
    return (
        <div className="main-container" onMouseEnter={() => setVisible(!checkIfTouch && true)} onMouseLeave={() => setVisible(false)}>
            {visible ? (
                <div className="overlay-container">
                    <Button
                        className="overlay-bid-button font-15"
                        variant="fill-white"
                        onClick={() => history.push(url)}
                    >
                        Bid
                        <RiAuctionFill className="overlay-bid-icon" />
                    </Button>
                </div>
            ) : null}
            {children}
        </div>
    );
}

export default ProductCardOverlay;