import React, { useEffect, useState } from 'react';
import { Range } from 'rc-slider';
import { MdClear } from 'react-icons/md';
import { average } from '../../utils/price';

import '../../styles/filter/PriceFilter.scss';

const PriceFilter = ({ minPrice: maxFilterValue, maxPrice: minFilterValue, prices, handleClick, maxValue, minValue }) => {

    const [price, setPrice] = useState(null);
    const [minPrice, setMinPrice] = useState(maxFilterValue || 0);
    const [maxPrice, setMaxPrice] = useState(minFilterValue || 0);
    const [avgPrice, setAvgPrice] = useState(0);
    const [maxCount, setMaxCount] = useState(0);
    const [active, setActive] = useState(false);

    const count = Math.max.apply(0, prices);

    
    useEffect(() => {
        if (prices === undefined)
            return;
        setPrice(prices);
        setMinPrice(minFilterValue === undefined ? Math.floor(minValue) : minFilterValue);
        setMaxPrice(maxFilterValue === undefined ? Math.ceil(maxValue) : maxFilterValue);
        setActive(minFilterValue !== undefined || maxFilterValue !== undefined);
        setAvgPrice(Math.floor(average(prices)));
        setMaxCount(count);
    }, [prices])

    const priceChange = (price) => {
        setMinPrice(price[0]);
        setMaxPrice(price[1]);
    }

    const afterPriceChange = (price) => {
        setActive(true);
        handleClick({ minPrice: price[1], maxPrice: price[0] });
    }

    const clearPrice = () => {
        setActive(false);
        handleClick({ minPrice: null, maxPrice: null });
        setMinPrice(Math.floor(price));
        setMaxPrice(Math.floor(price));
    }

    return (
        <div className="price-filter-container">
            <div className="price-filter-title">
                FILTER BY PRICE
                {active ?
                    <MdClear onClick={clearPrice} className="list-clear-icon" />
                    : null}
            </div>
            <div className="price-range-container">
                {price !== null ?
                    <React.Fragment>
                        <div className="chart-container">
                            {price.map((count, i) => (
                                <div
                                    key={i}
                                    className="histogram-bar"
                                    style={{ width: 'calc(100% / ' + price.length + ')', height: count === 0 ? 0 : 'calc(75px / ' + (maxCount / count) + ')' }}
                                />
                            ))}
                        </div>
                        <Range
                            className="slider"
                            min={Math.floor(minValue)}
                            max={Math.ceil(maxValue)}
                            allowCross={false}
                            value={[minPrice, maxPrice]}
                            onChange={priceChange}
                            onAfterChange={afterPriceChange}
                        />
                    </React.Fragment> : null}
            </div>
            <div className="prices-container">
                {"$" + minPrice + " - $" + maxPrice}
            </div>
            <div className="prices-container">
                The average price is ${avgPrice}
            </div>
        </div>
    );
}

export default PriceFilter;