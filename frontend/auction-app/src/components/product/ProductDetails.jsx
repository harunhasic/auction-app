import React, { useState } from 'react';
import { Button, Form, OverlayTrigger, Tooltip } from 'react-bootstrap';
import { RiHeartFill } from "react-icons/ri";
import { IoIosArrowForward } from "react-icons/io";
import moment from 'moment';

import '../../styles/product/ProductDetails.scss';

const ProductDetails = ({ product, ownProduct, active }) => {

    const [loading, setLoading] = useState(false);

    function convertMS( milliseconds ) {
        var day, hour, minute, seconds;
        seconds = Math.floor(milliseconds / 1000);
        minute = Math.floor(seconds / 60);
        seconds = seconds % 60;
        hour = Math.floor(minute / 60);
        minute = minute % 60;
        day = Math.floor(hour / 24);
        hour = hour % 24;
        return {
            day: day,
            hour: hour,
            minute: minute,
            seconds: seconds
        };
    }
      
    const getTimeInfo = () => {
        const productStarts = moment(product.startDate);
        const productEndDate = new Date(product.endDate);
        const now = new Date();
        const difference = (productEndDate.getTime() - now.getTime());
        const leftTime = convertMS(difference);
        if (moment().isBefore(productStarts))
            return (
                <>
                    Time start: {productStarts.format("D MMMM YYYY [at] HH:mm")}
                    <br />
                    Time end: {moment(product.endDate).format("D MMMM YYYY [at] HH:mm")}
                </>
            );
        const timeLeft = !active ? 0 : leftTime.day + " Days "  + leftTime.hour + " hours " + leftTime.minute + " minutes" ;
        return (
            <>
                Time left: {timeLeft}
            </>
        );
    }

    return (
        <div className="product-info">
            <div>
                <h1>
                    {product.name}
                </h1>
                <div className="featured-product-price">
                    Start from ${product.startPrice}
                </div>
            </div>
            <div className="place-bid">
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
                        Enter ${product.startPrice} or more
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
                Highest bid: {product.highestBid}
                <span className="span-bid">
                   
                </span>
                <br />
                No bids: 
                <br />
                {getTimeInfo()}
            </div>
            <div>
                <div className="details-18">
                    Details
                    <div className="line" />
                    <div className="details-15">
                        {product.description}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductDetails;