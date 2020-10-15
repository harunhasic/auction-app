import React, { useState } from 'react';
import { Button, Form, OverlayTrigger, Tooltip } from 'react-bootstrap';
import { RiHeartFill } from "react-icons/ri";
import { IoIosArrowForward } from "react-icons/io";
import moment from 'moment';

import '../../styles/product/ProductDetails.scss';

const ProductInfo = ({ product, bid, wishlist, bids, minPrice, ownProduct, active, wished }) => {

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
                <div style={{ marginTop: 10 }} className="featured-product-price">
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
                        style={{ width: 192, padding: 0 }}
                        size="xxl"
                        variant="transparent-black-shadow"

                    >
                        PLACE BID
                        <IoIosArrowForward style={{ fontSize: 24 }} />
                    </Button>
                </OverlayTrigger>
            </div>
            <div style={{ color: '#9B9B9B' }}>
                Highest bid: {' '}
                <span style={{ color: '#8367D8', fontWeight: 'bold' }}>
                    ${bids[0] === undefined ? 0 : bids[0].price}
                </span>
                <br />
                No bids: {bids.length}
                <br />
                {getTimeInfo()}
            </div>
            <div>
                <Button
                    className="wishlist-button"
                    style={wished ? { borderColor: '#8367D8' } : null}
                    variant="transparent-gray"
                >
                    Wishlist
                    {wished ? (
                        <RiHeartFill style={{ fontSize: 22, marginLeft: 5, color: '#8367D8' }} />
                    ) : (
                            <RiHeartFill style={{ fontSize: 22, marginLeft: 5, color: '#ECECEC' }} />
                        )}
                </Button>
                <div className="font-18" style={{ marginTop: 15 }}>
                    Details
                    <div className="gray-line" />
                    <div className="font-15">
                        {product.description}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ProductInfo;