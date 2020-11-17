import React, { useState, useEffect } from 'react';
import { Button, Form, OverlayTrigger, Tooltip } from 'react-bootstrap';
import { IoIosArrowForward } from "react-icons/io";
import moment from 'moment';
import convertMS from '../../utils/date'
import '../../styles/product/ProductDetails.scss';
import BidService from '../../Services/bid-service';
import ErrorComponent from '../notFound/ErrorComponent';

const bidService = new BidService();

const ProductDetails = ({ product, selfPosted, active, bidFunction, bids, minPrice }) => {

const [loading, setLoading] = useState(false);

const [bidAmount, setBidAmount] = useState("");
const [highestBid, setHighestBid] = useState(0);
const [hasError, setHasError] = useState(false);
const [errorMessage, setErrorMessage] = useState(null);

const productStarts = moment(product.startDate);
const productEndDate = new Date(product.endDate);
const now = new Date();
const difference = productEndDate.getTime() - now.getTime();
const leftTime = convertMS(difference);
const maximumBid = 99999.99;

useEffect(() => {
    async function fetchData() {
        try {
            const highestBid = await bidService.getHighestBid(product.id);
            setHighestBid(highestBid.data);
        } catch (error) {
            setHasError(true);
            setErrorMessage(error.toString());
        }
    }
    fetchData();
})

const toolTip = () => {
    let tooltipText = "";
    switch (true) {
        case !active:
            tooltipText = "Auction has not started for this product. Please try again later.";
            break;
        case selfPosted:
            tooltipText = "You can't bid on a product that you posted.";
            break;
        case bidAmount === "":
            return <div />;
        case isNaN(bidAmount):
            tooltipText = "Please enter a valid number.";
            break;
        case bidAmount < minPrice:
            tooltipText = "Price cannot be less than $" + minPrice;
            break;
        case bidAmount > maximumBid:
            tooltipText = "Price cannot be higher than $" + maximumBid;
            break;
        default:
            return <div />;
    }

    return (
        <Tooltip>
            {tooltipText}
        </Tooltip>
    );
}

async function handleBid() {
    setLoading(true);
    await bidFunction(bidAmount);
    setBidAmount("");
    setLoading(false);
    try {
        const highestBid = await bidService.getHighestBid(product.id);
        setHighestBid(highestBid.data);
    } catch (error) {
        setHasError(true);
        setErrorMessage(error.toString());
    }
}

function validateBid(amount) {
    setBidAmount(amount.replace(/(\.\d{2})\d+/, '$1'));
}

const timeInformation = () => {
    if (moment().isBefore(productStarts)) {
        return (
            <React.Fragment>
                Time start: {productStarts.format("D MMMM YYYY [at] HH:mm")}
                <br />
                Time end: {moment(product.endDate).format("D MMMM YYYY [at] HH:mm")}
            </React.Fragment>
        );
    }

    const timeLeft = !active ? <h3>Auction has finished</h3> : leftTime.day + " Days " + leftTime.hour + " hours " + leftTime.minute + " minutes";

    return (
        <React.Fragment>
            Time left: {timeLeft}
        </React.Fragment>
    );
}

const disabledButton = loading || !active || selfPosted || isNaN(bidAmount) || bidAmount < minPrice || bidAmount > maximumBid;

return (
    <React.Fragment>
        {!hasError ?
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
                            value={bidAmount}
                            disabled={selfPosted || !active || loading}
                            maxLength="10"
                            className="form-control-gray place-bid-form"
                            size="xl-18"
                            type="text"
                            onChange={e => validateBid(e.target.value)}
                            onKeyUp={e => e.key === 'Enter' ? handleBid() : null}
                        />
                        <div className="place-bid-label">
                            Enter ${minPrice} or more
                </div>
                    </div>
                    <OverlayTrigger
                        placement="right"
                        overlay={toolTip()}
                    >
                        <span className="tooltip-span">
                            <Button
                                disabled={disabledButton}
                                className={disabledButton ? "button-disabled" : "button-bid"}
                                size="xxl"
                                variant="transparent-black-shadow"
                                onClick={handleBid}
                            >
                                PLACE BID
                    <IoIosArrowForward className="arrow" />
                            </Button>
                        </span>
                    </OverlayTrigger>
                </div>
                <div className="highest-bid">
                    Highest bid: {''}
                    <span className="highest-bid-span">
                        {
                            bids.length ?
                                "$" + highestBid
                                : "No bids yet."
                        }
                    </span>
                    <br />
                        No bids: {bids.length}
                    <br />
                    {timeInformation()}
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
            : <ErrorComponent message={errorMessage}></ErrorComponent>
        }
    </React.Fragment>
);
}

export default ProductDetails;