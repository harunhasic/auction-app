import React, { useEffect, useState } from 'react';
import { ListGroup } from 'react-bootstrap';
import { MdClear } from 'react-icons/md';
import ProductService from '../../Services/product-service';

import '../../styles/filter/SizeFilter.scss'

const productService = new ProductService();

const SizeFilter = ({ size, allSizes, handleClick }) => {

const [sizes, setSizes] = useState([]);
const [activeSize, setActiveSize] = useState(size);

useEffect(() => {
    setActiveSize(size);
}, [size])


useEffect(() => {
    setSizes(allSizes);
}, [allSizes])

const sizeClick = (size) => {
    if (activeSize === size) {
        setActiveSize(undefined);
        handleClick(null);
    } else {
        setActiveSize(size);
        handleClick(size);
    }
}

return (
    <ListGroup variant="filter">
        <ListGroup.Item className="filter-list-title">
            FILTER BY SIZE
            {activeSize !== undefined ?
                <MdClear onClick={() => sizeClick(activeSize)} className="list-clear-icon" />
                : null}
        </ListGroup.Item>
        {sizes.map(size => (
            <ListGroup.Item
                key={size.size}
                action
                onClick={() => sizeClick(size.size)}
                className={size === activeSize ? "active-size" : "size-name"}
            >
                {size.size}
                {' (' + size.available + ')'}
            </ListGroup.Item>
        ))}
    </ListGroup>
);
}

export default SizeFilter;