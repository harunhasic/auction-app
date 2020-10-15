import React, { useState } from 'react';
import { Button, Form, OverlayTrigger, Tooltip } from 'react-bootstrap';
import { RiHeartFill } from "react-icons/ri";
import { IoIosArrowForward } from "react-icons/io";
import moment from 'moment';

import '../../styles/product/ProductDetails.scss';

const ProductInfo = ({ product, minPrice, ownProduct, active, wished }) => {

    const [loading, setLoading] = useState(false);

    const getTimeInfo = () => {
        const productStartDate = moment(product.startDate);
        if (moment().isBefore(productStartDate))
            return (
                <>
                    Time start: {productStartDate.format("D MMMM YYYY [at] HH:mm")}
                    <br />
                    Time end: {moment(product.endDate).format("D MMMM YYYY [at] HH:mm")}
                </>
            );
        const timeLeft = !active ? 0 : moment.duration(moment(product.endDate).diff(moment())).format("D [days] h [hours] m [minutes]");
        return (
            <>
                Time left: {timeLeft}
            </>
        );
    }

    return (
        <div className="product-info-container">
            <div>
                <h1>
                    {product.name}
                </h1>
                <div className="featured-product-price">
                    Start from ${product.startPrice}
                </div>
            </div>
            <div className="place-bid-container">
                <div>
                    <Form.Control
                        value={null}
                        disabled={ownProduct || !active || loading}
                        maxLength="7"
                        className="form-control-gray place-bid-form"
                        size="xl-18"
                        type="text"

                    />
                    <div className="place-bid-label">
                        Enter ${minPrice} or more
                    </div>
                </div>
                <OverlayTrigger
                    placement="right"
                >
                    <Button
                        disabled={ownProduct || !active || loading || isNaN()}
                        className = "button-bid"
                        size="xxl"
                        variant="transparent-black-shadow"

                    >
                        PLACE BID
                        <IoIosArrowForward className="arrow" />
                    </Button>
                </OverlayTrigger>
            </div>
            <div className="highest-bid">
                Highest bid: {' '}
                <span className="span-bid">
                   
                </span>
                <br />
                No bids: 
                <br />
                {getTimeInfo()}
            </div>
            <div>
                <Button
                    className="wishlist-button"
                    className={wished ? "wished" : null}
                    variant="transparent-gray"
                >
                </Button>
                <div className="details-18">
                    Details
                    <div className="gray-line" />
                    <div className="details-15">
                        {product.description}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductInfo;