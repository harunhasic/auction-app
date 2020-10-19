import React, { useEffect, useState } from 'react';
import { Button, Image, ListGroup } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';
import ProductService from '../../Services/product-service';
import CategoryService from '../../Services/category-service';
import { IoIosArrowForward } from "react-icons/io";
import { categoryUrl, allCategoryUrl, subcategoryUrl, productUrl } from '../../utils/RedirectUrls';
import '../../styles/landingPage/Landing.scss';
import MapImage from '../MapImage/MapImage';
import MapSubCategory from '../MapImage/MapSubcategory'
import SubCategoryService from '../../Services/subcategory-service';

const productService = new ProductService();
const categoryService = new CategoryService();
const subCategoryService = new SubCategoryService();

const LandingPage = ({ deleteBreadcrumb }) => {
  const history = useHistory();

  const [categories, setCategories] = useState([]);
  const [randomSubcategories, setRandomSubcategories] = useState([]);
  const [newProducts, setNewProducts] = useState([]);
  const [lastProducts, setLastProducts] = useState([]);
  const [topRatedProducts, setTopRatedProducts] = useState([]);
  const [featuredProducts, setFeaturedProducts] = useState([]);
  const [activePage, setActivePage] = useState(0);


  useEffect(() => {
    deleteBreadcrumb();
    async function fetchData() {
      try {
        await categoryService.getCategories().then(response => {
          setCategories(response.data);
        })
        await productService.getRandomProducts().then(response => {
          setFeaturedProducts(response.data);
        })
        await subCategoryService.getRandomSubCategories().then(response => {
          setRandomSubcategories(response.data);
        })
        await productService.getNewProducts().then(response => {
          setNewProducts(response.data);
        })
        await productService.getLastProducts().then(response => {
          setLastProducts(response.data);
        })
        await productService.getTopRatedProducts().then(response => {
          setTopRatedProducts(response.data);
        })
      } catch (e) { }
    }
    fetchData();
  }, [deleteBreadcrumb])

  console.log(newProducts);

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
          <div className={activePage === 0 ? "custom-tab" : null}  onClick={() => setActivePage(0)}>
            New Arrivals
          </div>
          <div className="space"></div>
          <div className={activePage === 1 ? "custom-tab" : null}  onClick={() => setActivePage(1)}>
            Top Rated
          </div>
          <div className="space"></div>
          <div className={activePage === 2 ? "custom-tab" : null}  onClick={() => setActivePage(2)}>
            Last chance
          </div>
        </div>
        <div className="line" />
        <div className="featured-items-container">
          {
            activePage === 0 ? (
              newProducts.map(product => (
                <MapImage key={product.id} data={product} size="xxl" url={productUrl(product)} />
              ))
            ) :  activePage === 1 ?  (
              topRatedProducts.map(product => (
                <MapImage key={product.id} data={product} size="xxl" url={productUrl(product)} />
              ))
              )
              :
              lastProducts.map(product => (
                <MapImage key={product.id} data={product} size="xxl" url={productUrl(product)} />
              ))
          }
        </div>
      </div>
    </>
  );
}

export default LandingPage;