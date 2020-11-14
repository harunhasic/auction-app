import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import { getUserId } from '../../utils/LocalStorageUtils';
import ProductService from '../../Services/product-service'
import { productUrl } from '../../utils/RedirectUrls';
import ProductPhoto from '../product/ProductPhoto';
import ProductDetails from '../product/ProductDetails';
import moment from 'moment';
import ErrorComponent from '../notFound/ErrorComponent';
import '../../styles/product/Product.scss';
import ProductCard from '../Map/ProductCard';
import CategoryService from '../../Services/category-service';
import BidService from '../../Services/bid-service';
import BidTable from '../bidding/BidTable';
import { Alert } from 'react-bootstrap';

const productService = new ProductService();
const categoryService = new CategoryService();
const bidsService = new BidService();

const ProductPage = ({  match, setBreadcrumb }) => {

    const userId = getUserId();
    const [product, setProduct] = useState(null);
    const [relatedProducts, setRelatedProducts] = useState([]);
    const [category, setCategory] = useState(null);
    const [active, setActive] = useState(true);
    const [minPrice, setMinPrice] = useState(0);
    const [hasError, setHasError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);
    const [bids, setBids] = useState([]);
    const [selfPosted, setSelfPosted] = useState(false);
    const [alertVisible, setAlertVisible] = useState(false);
    const [variant, setVariant] = useState(null);
    const [message, setMessage] = useState(null);
    let keepFlag = false;

    function notify(variant, message) {
      setMessage(message);
      setVariant(variant);
      setAlertVisible(true);
      keepFlag = true;
    }
  

    useEffect(() => {
        createBreadcrumb();
        async function fetchData() {
            const productId = match.params.id;
            const amount = 3;
            try {
                await productService.getProduct(productId).then(async response => {
                    const product = response.data;
                    setProduct(product);
                    setSelfPosted(product.user.id === userId);
                    setActive(moment().isBetween(moment(product.startDate), moment(product.endDate)));
                    setMinPrice(product.startPrice);
                    const bids = await bidsService.getBids(productId);             
                    const userBestBid = Math.max(...bids.data.map(bid => bid.user.id === userId ? bid.amount : 0), 0);
                    setMinPrice(userBestBid === 0 ? product.startPrice : userBestBid + 0.01);
                    setBids(bids.data);   
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

    async function bid(price) {
        if (userId === null) {
            notify("warning", "You have to be logged in to place bids.");
            return;
        }
        try {
            const bidRequest = {
                price: parseFloat(price),
                productId: product.id,
                userId: userId
            };
            await bidsService.addBid(bidRequest);
            const newBids = await bidsService.getBids(product.id);
            console.log(newBids);
            const minPrice = Math.max(...newBids.data.map(bid => bid.user.id === userId ? bid.amount : 0), 0) + 0.01;
            setMinPrice(Math.round((minPrice + Number.EPSILON) * 100) / 100);
            if (userId === newBids.data[0].user.id) {
                notify("success", "Congratulations! You are the highest bidder")
        }
            else 
                notify("warning", "There are bids higher than yours. You could again.")
            setBids(newBids.data);    
    }
      catch (e) { 
          setHasError(true);
          setErrorMessage(e.toString());
      }
    }

    return (
        <React.Fragment>
            <div className={alertVisible ? "alert-div" : null}>
              <Alert dismissible onClose={() => setAlertVisible(false)} transition={false} show={alertVisible} variant={variant}>
               {message}
              </Alert>
            </div>
            {
             product !== null ? (
                <div className="product-container">
                  <ProductPhoto photos={product.photos} />
                    <ProductDetails
                        product={product}
                        minPrice={minPrice}
                        active={active}
                        bid={bid}
                        bids={bids}
                        selfPosted={selfPosted}
                    />
                </div>
             ) : null}
              {
                hasError ?
                <ErrorComponent message = {errorMessage}></ErrorComponent>
                :null
              }
               {userId !== null && bids.length !== 0 ? (
                <BidTable bids={bids} />
            ) : null}
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