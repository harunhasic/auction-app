import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import { getUserId } from '../../utils/LocalStorageUtils';
import ProductService from '../../Services/product-service'
import { productUrl } from '../../utils/RedirectUrls';
import ProductPhoto from '../product/ProductPhoto';
import ProductDetails from '../product/ProductDetails';
import moment from 'moment';
import ErrorComponent from '../notFound/ErrorComponent';
import '../../styles/product/ProductPage.scss';
import ProductCard from '../Map/ProductCard';
import CategoryService from '../../Services/category-service';



const productService = new ProductService();
const categoryService = new CategoryService();

const ProductPage = ({ match, setBreadcrumb }) => {
    const [product, setProduct] = useState(null);
    const [relatedProducts, setRelatedProducts] = useState([]);
    const [category, setCategory] = useState(null);
    const [active, setActive] = useState(true);
    const [minPrice, setMinPrice] = useState(0);
    const [hasError, setHasError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);

    useEffect(() => {
        createBreadcrumb();
        async function fetchData() {
            const productId = match.params.id;
            const amount = 3;
            try {
                await productService.getProduct(productId).then(async response => {
                    const product = response.data;
                    setProduct(product);
                    //sets a product to be active if his endDate is not surpassed, if not, display errorComponent
                    setActive(moment().isBetween(moment(product.startDate), moment(product.endDate)));
                    setMinPrice(product.startPrice);
                    await categoryService.getBySubcategoryId(product.subcategory.id).then(response => {
                        setCategory(response.data);
                    })
                })
                await productService.getRelatedProducts(productId, amount).then(response => {
                    setRelatedProducts(response.data);
                }) 
                setHasError(false);
            } catch (error) {      
                setHasError(true);
                setErrorMessage(error.toString());
            }
        }
        fetchData();
    }, [match.params.id])

    const createBreadcrumb = () => {
        const urls = match.url.split("/").slice(1, -1);
        let matchUrl = "";
        setBreadcrumb("SINGLE PRODUCT", [...urls.map(url => {
            matchUrl += "/" + url;
            return {
                text: url.toUpperCase().split("_").join(" "),
                href: encodeURI(matchUrl)
            }
        }),]);
    }

    return (
        <React.Fragment>
            {
             !hasError && product !== null ? (
                <div className="product-container">
                  <ProductPhoto photos={product.photos} />
                    <ProductDetails
                        product={product}
                        minPrice={minPrice}
                        active={active}
                    />
                </div>
             ) : <ErrorComponent message = {errorMessage}></ErrorComponent>}
            {
             product !== null ? (
              <div className="featured-container">
                <h2>
                    Related products
                </h2>
                <div className="line" />
                <div className="featured-items-container">
                    {
                      relatedProducts.map(product => (
                        <ProductCard key={product.id} data={product} size="xxl" url={productUrl(product, category)} />
                      ))
                    }
                </div>
              </div>
             ) : null }
        </React.Fragment>
    );
}

export default withRouter(ProductPage);