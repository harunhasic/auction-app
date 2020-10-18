import React, { useEffect, useState } from 'react';
import { Button, Image, ListGroup } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';
import { getRandomFeaturedProducts, getNewProducts, getLastProducts } from '../../server/product';
import { getRandomSubcategories } from '../../server/subcategory';
import { getCategories } from '../../server/category';
import { IoIosArrowForward } from "react-icons/io";
import { categoryUrl, allCategoryUrl, subcategoryUrl, productUrl } from "../../utils/RedirectUrls";

import '../../styles/landingPage/Landing.scss';
import MapImage from '../MapImage/MapImage';
import MapSubCategory from '../MapImage/MapSubcategory'

const LandingPage = ({ deleteBreadcrumb }) => {
  const history = useHistory();

  const [categories, setCategories] = useState([]);
  const [randomSubcategories, setRandomSubcategories] = useState([]);
  const [newAndLastProducts, setNewAndLastProducts] = useState([]);
  const [featuredProducts, setFeaturedProducts] = useState([]);
  const [activePage, setActivePage] = useState(0);

  useEffect(() => {
    deleteBreadcrumb();
    async function fetchData() {
      try {
        setCategories(await getCategories());
        setFeaturedProducts(await getRandomFeaturedProducts());
        setRandomSubcategories(await getRandomSubcategories());
        const newProducts = await getNewProducts();
        const lastProducts = await getLastProducts();
        setNewAndLastProducts([newProducts, lastProducts]);
      } catch (e) { }
    }
    fetchData();
  }, [deleteBreadcrumb])
  
  

  return (
    <>
      <div className="landing-page-container">
        <ListGroup variant="categories">
          <ListGroup.Item className="categories-link" action onClick={() => history.push(allCategoryUrl)}>CATEGORIES</ListGroup.Item>
          {categories.map(category => (
            <ListGroup.Item key={category.name} action onClick={() => history.push(categoryUrl(category))}>{category.name}</ListGroup.Item>
          ))}
          <ListGroup.Item>All Categories</ListGroup.Item>
        </ListGroup>

        {featuredProducts.length !== 0 ?
          <div className="featured-main-container">
            <div className="featured-product-container">
              <h1>
                {featuredProducts[0].name}
              </h1>

              <div className="featured-product-price">
                Start from - ${featuredProducts[0].startPrice}
              </div>

              <div className="featured-product-description">
                {featuredProducts[0].description}
              </div>

              <Button
                className="landing-button"
                onClick={() => history.push(productUrl(featuredProducts[0]))}
              >
                BID NOW
                <IoIosArrowForward className="arrow-forward" />
              </Button>
            </div>
            <Image className="featured-product-image" src={featuredProducts[0].photos[0].photoUrl} />
          </div> : null}
      </div>

      <div className="featured-container">
        <h2 className="featured-heading">
          Featured Collections
      	</h2>
        <div className="line" />
        <div className="featured-items-container">
          {randomSubcategories.map(subcategory => (
            <MapSubCategory key={subcategory.id} data={subcategory} size="xxl" url={subcategoryUrl(subcategory)} />
          ))} 
        </div>
      </div>

      <div className="featured-container">
        <h2 className="featured-heading">
          Featured Products
      	</h2>
        <div className="line" />
        <div className="featured-items-container">
          {featuredProducts.slice(1).map(product => (
            <MapImage key={product.id} data={product} size="xl" url={productUrl(product)} />
          ))}
        </div>
      </div>

      <div className="featured-container">
        <div className="tabs-container">
          <div style={activePage === 0 ? { borderBottom: '4px solid #8367D8' } : null} className="custom-tab" onClick={() => setActivePage(0)}>
            New Arrivals
          </div>
          <div style={activePage === 1 ? { borderBottom: '4px solid #8367D8' } : null} className="custom-tab" onClick={() => setActivePage(1)}>
            Top Rated
          </div>
        </div>
        <div className="line" />
        <div className="featured-items-container">
          {newAndLastProducts.length !== 0 ? newAndLastProducts[activePage].map(product => (
            <MapImage key={product.id} data={product} size="lg" url={productUrl(product)} />
          )) : null}
        </div>
      </div>
    </>
  );
}

export default LandingPage;