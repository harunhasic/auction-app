import React, { useEffect, useState } from 'react';
import { Button, Image, ListGroup } from 'react-bootstrap';
import { useHistory } from 'react-router-dom';
import ProductService from '../../Services/product-service';
import CategoryService from '../../Services/category-service';
import { IoIosArrowForward } from "react-icons/io";
import { categoryUrl, allCategoryUrl, subcategoryUrl, productUrl } from '../../utils/RedirectUrls';
import '../../styles/landingPage/Landing.scss';
import ProductCard from '../Map/ProductCard';
import SubCategoryCard from '../Map/MapSubcategory'
import SubCategoryService from '../../Services/subcategory-service';
import ErrorComponent from '../notFound/ErrorComponent';

const productService = new ProductService();
const categoryService = new CategoryService();
const subCategoryService = new SubCategoryService();

const getCategoryBySubcategory = (categories, subcategory) => {
  return categories.find(category => {
    return category.subcategories.find(s => s.id === subcategory.id);
  });
}

const LandingPage = ({ deleteBreadcrumb }) => {
  const history = useHistory();

  const [categories, setCategories] = useState([]);
  const [randomSubcategories, setRandomSubcategories] = useState([]);
  const [newProducts, setNewProducts] = useState([]);
  const [lastProducts, setLastProducts] = useState([]);
  const [topRatedProducts, setTopRatedProducts] = useState([]);
  const [featuredProducts, setFeaturedProducts] = useState([]);
  const [activePage, setActivePage] = useState(0);
  const [hasError, setHasError] = useState(false);
  const [errorMessage, setErrorMessage] = useState(null);

  useEffect(() => {
    deleteBreadcrumb();
    async function fetchData() {
      const amount = 8;
      const featuredAmount = 5;
      const subcategoriesAmount = 4;
      try {
        await categoryService.getCategories().then(response => {
          setCategories(response.data);
        })
        await productService.getRandomProducts(featuredAmount).then(response => {
          setFeaturedProducts(response.data);
        })
        await subCategoryService.getRandomSubCategories(subcategoriesAmount).then(response => {
          setRandomSubcategories(response.data);
        })
        await productService.getNewProducts(amount).then(response => {
          setNewProducts(response.data);
        })
        await productService.getLastProducts(amount).then(response => {
          setLastProducts(response.data);
        })
        await productService.getTopRatedProducts(amount).then(response => {
          setTopRatedProducts(response.data);
        })
      } catch (error) {
        setHasError(true);
        setErrorMessage(error.toString())
      }
    }
    fetchData();
  }, [deleteBreadcrumb])

  const productInFocus = featuredProducts[0];

  return (
    <React.Fragment>
      <div className="landing-page-container">
        <ListGroup variant="categories">
          <ListGroup.Item className="categories-link" action onClick={() => history.push(allCategoryUrl)}>CATEGORIES</ListGroup.Item>
          {
            categories.map(category => (
              <ListGroup.Item key={category.name} action onClick={() => history.push(categoryUrl(category))}>{category.name}</ListGroup.Item>
            ))
          }
          <ListGroup.Item>All Categories</ListGroup.Item>
        </ListGroup>
        {
          !hasError && featuredProducts.length !== 0 ?
            <div className="featured-main-container">
              <div className="featured-product-container">
                <h1>
                  {productInFocus.name}
                </h1>

                <div className="featured-product-price">
                  Start from - ${productInFocus.startPrice}
                </div>

                <div className="featured-product-description">
                  {productInFocus.description}
                </div>

                <Button
                  className="landing-button"
                  onClick={() => history.push(productUrl(productInFocus, getCategoryBySubcategory(categories, productInFocus.subcategory)))}
                >
                  BID NOW
                <span className="arrow-forward">&#10095;</span>
                </Button>
              </div>
              <Image className="featured-product-image" src={productInFocus.photos[0].photoUrl} />
            </div> : <ErrorComponent message={errorMessage}></ErrorComponent>
        }
      </div>

      <div className="featured-container">
        <h2 className="featured-heading">
          Featured Collections
      	</h2>
        <div className="line" />
        <div className="featured-items-container">
          {
            randomSubcategories.map(subcategory => (
              <SubCategoryCard
                key={subcategory.id} data={subcategory}
                size="xxl"
                url={subcategoryUrl(subcategory)}
              />
            ))
          }
        </div>
      </div>

      <div className="featured-container">
        <h2 className="featured-heading">
          Featured Products
      	</h2>
        <div className="line" />
        <div className="featured-items-container">
          {
            featuredProducts.slice(1).map(product => (
              <ProductCard key={product.id} data={product} size="xl" url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))} />
            ))
          }
        </div>
      </div>

      <div className="featured-container">
        <div className="tabs-container">
          <div className={activePage === 0 ? "custom-tab" : null} onClick={() => setActivePage(0)}>
            New Arrivals
          </div>
          <div className="space"></div>
          <div className={activePage === 1 ? "custom-tab" : null} onClick={() => setActivePage(1)}>
            Top Rated
          </div>
          <div className="space"></div>
          <div className={activePage === 2 ? "custom-tab" : null} onClick={() => setActivePage(2)}>
            Last chance
          </div>
        </div>
        <div className="line" />
        <div className="featured-items-container">
          {
            activePage === 0 ? (
              newProducts.map(product => (
                <ProductCard key={product.id} data={product} size="xxl" url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))} />
              ))
            ) : activePage === 1 ? (
              topRatedProducts.map(product => (
                <ProductCard key={product.id} data={product} size="xxl" url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))} />
              ))
            ) :
                lastProducts.map(product => (
                  <ProductCard key={product.id} data={product} size="xxl" url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))} />
                ))
          }
        </div>
      </div>
    </React.Fragment>
  );
}

export default LandingPage;