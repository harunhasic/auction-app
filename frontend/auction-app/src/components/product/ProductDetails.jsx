import React, { useState } from 'react';
import { Button, Form, OverlayTrigger, Tooltip } from 'react-bootstrap';
import { RiHeartFill } from "react-icons/ri";
import { IoIosArrowForward } from "react-icons/io";
import moment from 'moment';
import convertMS from '../../utils/date'
import '../../styles/product/ProductDetails.scss';

const ProductDetails = ({ product, active }) => {
    const getTimeInfo = () => {
        const productStarts = moment(product.startDate);
        const productEndDate = new Date(product.endDate);
        const now = new Date();
        const difference = productEndDate.getTime() - now.getTime();
        const leftTime = convertMS(difference);
        
        if (moment().isBefore(productStarts))
            return (
                <React.Fragment>
                    Time start: {productStarts.format("D MMMM YYYY [at] HH:mm")}
                    <br />
                    Time end: {moment(product.endDate).format("D MMMM YYYY [at] HH:mm")}
                </React.Fragment>
            );
        const timeLeft = !active ? <h3>Auction finished</h3> : leftTime.day + " Days "  + leftTime.hour + " hours " + leftTime.minute + " minutes";
        return (
            <React.Fragment>
                Time left: {timeLeft}
            </React.Fragment>
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
                        maxLength="7"
                        className="form-control-gray place-bid-form"
                        size="xl-18"
                        type="text"
                    />
                    <div className="place-bid-label">
                        Enter ${product.startPrice} or more
                    </div>
                </div>
                <OverlayTrigger placement="right">
                    <Button
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
                <span className="span-bid"/>
                <br />
                No bids: 
                <br />
                {getTimeInfo()}
            </div>
            <div>
                <div className="product-details-heading">
                    Details
                    <div className="line" />
                    <div className="product-details">
                        {product.description}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductDetails;