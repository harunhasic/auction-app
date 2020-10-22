import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import { getUserId } from '../../utils/LocalStorageUtils';
import ProductService from '../../Services/product-service'
import { productUrl } from '../../utils/RedirectUrls';
import ProductPhoto from '../product/ProductPhoto';
import ProductDetails from '../product/ProductDetails';
import moment from 'moment';

import '../../styles/product/ProductPage.scss';
import MapImage from '../MapImage/MapImage';
import { RiContactsBookLine } from 'react-icons/ri';


const productService = new ProductService();

const ProductPage = ({ match, setBreadcrumb }) => {

    const [product, setProduct] = useState(null);
    const [relatedProducts, setRelatedProducts] = useState([]);
    const [active, setActive] = useState(true);
    const [minPrice, setMinPrice] = useState(0);

    useEffect(() => {
        createBreadcrumb();
        async function fetchData() {
            const productId = match.params.id;
            const data = 0;
            try {
                await productService.getProduct(productId).then(response => {
                    setProduct(response.data);
                })
                await productService.getRelatedProducts(productId).then(response => {
                    setRelatedProducts(response.data);
                })
                setActive(moment().isBetween(moment(new Date()), moment(product.endDate), null, "[)"));
                setMinPrice(product.startPrice);
            } catch (e) { }
        }
        fetchData();
    }, [match.params.id])
    const createBreadcrumb = () => {
        const url = match.url.split("/").slice(1, -1);
        setBreadcrumb("SINGLE PRODUCT", [...url.map((element, i) => {
            return {
                text: element.toUpperCase().split("_").join(" "),
                href: "/" + url.slice(0, i + 1).join("/")
            }
        }),]);
    }


    return (
        <>
            {product !== null ? (
                <div className="product-container">
                    <ProductPhoto photos={product.photos} />
                    <ProductDetails
                        product={product}
                        minPrice={minPrice}
                        active={active}
                    />
                </div>
            ) : null}
            {product !== null ? (
                <div style={{ marginTop: 150 }} className="featured-container">
                    <h2>
                        Related products
                    </h2>
                    <div className="line" />
                    <div className="featured-items-container">
                        {relatedProducts.map(product => (
                            <MapImage key={product.id} data={product} size="xxl" url={productUrl(product)} />
                        ))}
                    </div>
                </div>
            ) : null}
        </>
    );
}

export default withRouter(ProductPage);