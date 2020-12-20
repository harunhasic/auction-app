import React, { useEffect, useState } from 'react';
import { ListGroup } from 'react-bootstrap';
import { MdClear } from 'react-icons/md';
import "../../styles/filter/ColorFilter.scss"

const ColorFilter = ({ color, allColors, handleClick }) => {

    const [colors, setColors] = useState([]);
    const [activeColor, setActiveColor] = useState(color);

    useEffect(() => {
        setActiveColor(color);
    }, [color])

    useEffect(() => {
    if (allColors === undefined) {
        return;
    }
    setColors(allColors);
}, [allColors]);

const colorClick = (color) => {
    if (activeColor === color) {
        setActiveColor(undefined);
        handleClick(null);
    } else {
        setActiveColor(color);
        handleClick(color);
    }
}

return (
    <ListGroup variant="filter">
        <ListGroup.Item className="filter-list-title">
            FILTER BY COLOR
                {activeColor !== undefined ?
                <MdClear onClick={() => colorClick(activeColor)} className="list-clear-icon" />
                : null}
        </ListGroup.Item>
        {colors.map(color => (
            <ListGroup.Item
                key={color}
                action
                onClick={() => colorClick(color)}
                className={color === activeColor ? "active-color" : "color-name"}
            >
                {color}
            </ListGroup.Item>
        ))}
    </ListGroup>
);
}

export default ColorFilter;