import React, { useEffect, useState } from 'react';
import { withRouter } from 'react-router-dom';
import { getUserId } from '../../utils/LocalStorageUtils';
import { getProduct, getRelatedProducts } from '../../server/product';
import { productUrl } from '../../utils/RedirectUrls';
import ProductPhotos from '../product/ProductImages';
import ProductInfo from '../product/ProductDetails';
import moment from 'moment';

import '../../styles/product/Product.scss';
import MapImage from '../MapImage/MapImage';

const ItemPage = ({ match, setBreadcrumb, showMessage }) => {
    const personId = getUserId();

    const [product, setProduct] = useState(null);
    const [relatedProducts, setRelatedProducts] = useState([]);
    const [active, setActive] = useState(true);
    const [ownProduct, setOwnProduct] = useState(false);
    const [minPrice, setMinPrice] = useState(0);

    useEffect(() => {
        formBreadcrumb();
        const fetchData = async () => {
            const productId = match.params.id;
            try {
                const data = await getProduct(productId, personId);
                setActive(moment().isBetween(moment(data.startDate), moment(data.endDate), null, "[)"));
                setOwnProduct(data.personId === personId);
                setProduct(data);
                if (personId === null) {
                    setRelatedProducts(await getRelatedProducts(productId));
                }
                setMinPrice(data.startPrice);
            } catch (e) { }
        }

        fetchData();
        // eslint-disable-next-line
    }, [match.params.id])

    const formBreadcrumb = () => {
        const urlElements = match.url.split("/").slice(1, -1);
        setBreadcrumb("SINGLE PRODUCT", [...urlElements.map((el, i) => {
            return {
                text: el.toUpperCase().split("_").join(" "),
                href: "/" + urlElements.slice(0, i + 1).join("/")
            }
        }), { text: "SINGLE PRODUCT" }]);
    }


    return (
        <>
            {product !== null ? (
                <div className="product-container">
                    <ProductPhotos photos={product.photos} />
                    <ProductInfo
                        product={product}
                        minPrice={minPrice}
                        ownProduct={ownProduct}
                        active={active}
                    />
                </div>
            ) : null}
            {personId === null && product !== null ? (
                <div style={{ marginTop: 150 }} className="featured-container">
                    <h2>
                        Related products
                    </h2>
                    <div className="gray-line" />
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

export default withRouter(ItemPage);