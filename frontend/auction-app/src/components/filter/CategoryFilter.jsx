import React, { useEffect, useState } from 'react';
import { ListGroup } from 'react-bootstrap';
import { FaPlus, FaMinus } from 'react-icons/fa';
import { capitalize } from '../../utils/capitalize';
import CategoryService from '../../Services/category-service';
import ProductService from '../../Services/product-service';

import '../../styles/filter/CategoryFilter.scss';

const categoryService = new CategoryService();
const productService = new ProductService();

const CategoryFilter = ({ allCategories, filter, theCategory, handleClick }) => {
    
    const [activeCategory, setActiveCategory] = useState("");
    const [activeSubcategory, setActiveSubcategory] = useState("");

    useEffect(() => {
        setActiveCategory(filter.category || "");
        setActiveSubcategory(filter.subCategory || "");
    }, [filter])

    const activateCategory = (categoryName) => {
        setActiveSubcategory("");
        if (activeCategory === categoryName) {
            setActiveCategory("");
            handleClick({ category: "", subcategory: "" });
        }
        else {
            setActiveCategory(categoryName);
            handleClick({ category: categoryName, subcategory: "" });
        }
    }

    const activateSubcategory = (subcategoryName) => {
        setActiveSubcategory(subcategoryName);
        handleClick({ category: activeCategory, subcategory: subcategoryName });
    }
    


    return (
        <ListGroup variant="filter">
            <ListGroup.Item className="filter-list-title">PRODUCT CATEGORIES</ListGroup.Item>
            {allCategories.map(category => (
                <React.Fragment key={category.name}>
                    <ListGroup.Item
                        action
                        onClick={() => activateCategory(capitalize(category.name))}
                        className="category-name"
                    >
                        {category.name}
                        {category.name === activeCategory ?
                            <FaMinus className="fa-minus" /> : <FaPlus className="fa-plus" />}
                    </ListGroup.Item>
                    {category.name === activeCategory ? category.subcategories.map(subcategory => (
                        <ListGroup.Item
                            className="subcategories-name"
                            key={subcategory.name}
                            action
                            onClick={() => activateSubcategory(subcategory.name)}
                        >
                            {subcategory.name}
                        </ListGroup.Item>
                    )) : null}
                </React.Fragment>
            ))}
        </ListGroup>
    );
}

export default CategoryFilter;