import ProductCard from '../Map/ProductCard';
import React, { useEffect, useState } from 'react';
import { useHistory, useLocation } from 'react-router-dom';
import { allCategoryUrl, productUrl, shopUrl } from '../../utils/RedirectUrls';
import { BsArrowDown, BsArrowUp, BsGrid3X3GapFill } from "react-icons/bs";
import { FaThList } from "react-icons/fa";
import { Button, Form, Spinner } from 'react-bootstrap';
import ItemNotFound from '../notFound/NotFound';
import * as qs from 'query-string';
import { capitalize } from '../../utils/capitalize';
import '../../styles/shop/Shop.scss';
import ProductListView from '../Map/ProductListView';
import ProductCardOverlay from '../../components/Map/ProductCardOverlay';
import ProductService from '../../Services/product-service';
import CategoryService from '../../Services/category-service';
import CategoryFilter from '../filter/CategoryFilter';
import ColorFilter from '../filter/ColorFilter';
import PriceFilter from '../filter/PriceFilter';
import SizeFilter from '../filter/SizeFilter';
import ErrorComponent from '../notFound/ErrorComponent';

let pageNumber = 1;
const productService = new ProductService();
const categoryService = new CategoryService();
let queryEntry = false;

const getCategoryBySubcategory = (categories, subcategory) => {
    return categories.find(category => {
        return category.subcategories.find(s => s.id === subcategory.id);
    });
}

const Shop = ({ setBreadcrumb }) => {

    const history = useHistory();
    const urlParams = qs.parse(history.location.search);

    const [products, setProducts] = useState([]);
    const [gridLayout, setGridLayout] = useState(true);
    const [prices, setPrices] = useState([0]);
    const [loading, setLoading] = useState(true);
    const [filter, setFilter] = useState({ pageNumber: 1, pageSize: 10, name: null, minPrice: null, maxPrice: null, color: null, size: null, sortKey: null, ascending: null, subcategory: null, category: null });
    const [hasError, setHasError] = useState(false);
    const [errorMessage, setErrorMessage] = useState(null);
    const [categories, setCategories] = useState([]);
    const [sortAsc, setSortAsc] = useState(false);
    const [colors, setColors] = useState(["White", "Black", "Red", "Green", "Blue", "Yellow", "Gold", "Silver"]);
    const [sizes, setSizes] = useState(["Large", "Small", "Medium", "Extra Large"]);
    const [availableSizeOne, setAvailableSizeOne] = useState(0);
    const [availableSizeTwo, setAvailableSizeTwo] = useState(0);
    const [availableSizeThree, setAvailableSizeThree] = useState(0);
    const [availableSizeFour, setAvailableSizeFour] = useState(0);

    const maxValue = Math.max(...prices);
    const minValue = Math.min(...prices);

    useEffect(() => {
        setLoading(true);
        const fromHome = history.location.state != null && history.location.state.fromHome;
        createBreadcrumb(fromHome);
    }, [history.location.pathname, history.location.search])


    useEffect(() => {
        queryEntry = true;
    }, [urlParams.query])


    const createBreadcrumb = (fromHome) => {
        const urls = history.location.pathname.split("/").slice(1);
        let matchUrl = "";
        if (urls.length === 1) {
            setBreadcrumb("SHOP", [{ text: "SHOP"}, { text: "ALL CATEGORIES" }]);
        } else {
            setBreadcrumb("SHOP", urls.map(url => {
                matchUrl += "/" + url;
                return {
                    text: url.toUpperCase().split("_").join(" "),
                    href: encodeURI(matchUrl)
                }
            }));
        }
        if (fromHome) {
            setTimeout(() => filterData(urls), 100);
        }
        else {
            filterData(urls);
        }
    }

    const filterByCategories = (selected) => {
        let categoryUrl = "";
        let subcategoryUrl = "";
        if (selected.category !== null) {
            categoryUrl = "/" + encodeURI(selected.category);
        }
        if (selected.subcategory !== null)
            subcategoryUrl = "/" + encodeURI(selected.subcategory);
        history.push({
            pathname: shopUrl + categoryUrl + subcategoryUrl,
            search: qs.stringify(urlParams)
        });
    }

    const filterByColor = (color) => {
        if (color === null) {
            delete urlParams.color;
        }
        else {
            urlParams.color = color;
        }
        history.push({
            search: qs.stringify(urlParams)
        });
    }

    function ascendingChange(ascending) {
        if (ascending === true) {
            urlParams.ascending = false;
            setSortAsc(false);
        } else {
            urlParams.ascending = true;
            setSortAsc(true);
        }
        history.push({
            search: qs.stringify(urlParams)
        })
    }

    const getNameFromUrl = (name) => {
        if (name === undefined) {
            return null;
        }
        name = name.split("_").join(" ");
        return capitalize(name);
    }

    const filterData = async (urlElements) => {
        const params = {
            pageNumber: 1,
            pageSize: 9,
            maxPrice: urlParams.minPrice,
            minPrice: urlParams.maxPrice,
            name: urlParams.query,
            color: urlParams.color,
            size: urlParams.size,
            ascending: sortAsc,
            sortKey: urlParams.sort,
            subCategory: getNameFromUrl(urlElements[2]),
            category: getNameFromUrl(urlElements[1])
        };
        const sizeOne = {
            size: sizes[0]
        }
        const sizeTwo = {
            size: sizes[1]
        }
        const sizeThree = {
            size: sizes[2]
        }
        const sizeFour = {
            size: sizes[3]
        }
        setFilter(params);
        try {
            await categoryService.getCategories().then(response => {
                setCategories(response.data);
            })
            await productService.filter(params).then(response => {
                setProducts(response.data.data);
            })
            await productService.getPrices().then(response => {
                setPrices(response.data);
            })
            await productService.filter(sizeOne).then(response => {
                setAvailableSizeOne(response.data.available);
            });
            await productService.filter(sizeTwo).then(response => {
                setAvailableSizeTwo(response.data.available);
            });
            await productService.filter(sizeThree).then(response => {
                setAvailableSizeThree(response.data.available);
            });
            await productService.filter(sizeFour).then(response => {
                setAvailableSizeFour(response.data.available);
            });
        } catch (e) {
        setHasError(true);
        setErrorMessage(e.toString());
      }
      setLoading(false);
    }
    const filterByPrice = (selected) => {
        if (selected.minPrice === null) {
            delete urlParams.minPrice;
        }
        else {
            urlParams.minPrice = selected.minPrice;
        }
        if (selected.maxPrice === null) {
            delete urlParams.maxPrice;
        }
        else {
            urlParams.maxPrice = selected.maxPrice;
        }
        history.push({
            search: qs.stringify(urlParams)
        });
    }

    const exploreMore = async () => {
        setLoading(true);
        pageNumber++;
        const refreshFilter = {
            pageNumber: pageNumber + 1,
            pageSize: 9,
            maxPrice: filter.maxPrice,
            minPrice: filter.minPrice,
            name: filter.name,
            color: filter.color,
            size: filter.size,
            ascending: filter.ascending,
            sortKey: filter.sortKey,
            subCategory: filter.subCategory,
            category: filter.category
        }
        try {
            const refreshProducts = await productService.filter(refreshFilter);
            setProducts([...products, ...refreshProducts.data.data]);
        } catch (e) {
            pageNumber--;
            setHasError(true);
            setErrorMessage(e.toString());
        }
        setLoading(false);
    }

    const sortBy = async (sort) => {
        pageNumber = 0;
        urlParams.sort = sort;
        history.push({
            search: qs.stringify(urlParams)
        });
    }

    const filterBySize = (size) => {
        if (size === null)
            delete urlParams.size;
        else
            urlParams.size = size;
        history.push({
            search: qs.stringify(urlParams)
        });
    }

    const sizeOne= {
        size: sizes[0],
        available: availableSizeOne
    }

    const sizeTwo = {
        size: sizes[1],
        available: availableSizeTwo
    }

    const sizeThree = {
        size: sizes[2],
        available: availableSizeThree
    }

    const sizeFour = {
        size: sizes[3],
        available: availableSizeFour
    }

    return (
    <React.Fragment>
        <div className="shop-container">
            <div className="shop-filters-container">
                <CategoryFilter filter={filter} handleClick={filterByCategories} allCategories={categories} />
                <PriceFilter 
                minPrice={urlParams.minPrice} 
                maxPrice={urlParams.maxPrice} 
                prices={prices} 
                handleClick={filterByPrice} 
                minValue={minValue}
                maxValue={maxValue}
                />
                <ColorFilter color={urlParams.color} allColors={colors} handleClick={filterByColor} />
                <SizeFilter size={urlParams.size} allSizes={[sizeOne, sizeTwo, sizeThree, sizeFour]} handleClick={filterBySize} />
            </div>
            <div className="shop-products-container">
                <div className="shop-sorting-dropdown">
                    <Form.Control className="sort-dropdown" defaultValue={urlParams.sort} onChange={e => sortBy(e.target.value)} as="select" >
                        <option className="sort-option" value="startDate">Sort by Newness</option>
                        <option className="sort-option" value="numberOfBids">Sort by Popularity</option>
                        <option className="sort-option" value="rating">Sort by Rating</option>
                        <option className="sort-option" value="startPrice">Sort by Price</option>
                    </Form.Control>
                    {loading ? <Spinner className="shop-spinner" animation="border" /> : null}
                    {
                        sortAsc ?
                            <BsArrowDown className="sorting-arrow" onClick={() => ascendingChange(sortAsc)}></BsArrowDown>
                            :
                            <BsArrowUp className="sorting-arrow" onClick={() => ascendingChange(sortAsc)}></BsArrowUp>
                    }
                    <div className="layout-buttons">
                        <Button onClick={() => setGridLayout(true)} className={gridLayout ? "button-layout" : "not-active"} size="lg" variant="transparent-black-shadow">
                            <BsGrid3X3GapFill className="grid-fill" />
                            Grid
                        </Button>
                        <Button onClick={() => setGridLayout(false)} className={gridLayout ? "not-active" : "button-layout"} size="lg" variant="transparent-black-shadow">
                            <FaThList className="grid-fill" />
                            List
                        </Button>
                    </div>
                </div>

                <div style={!gridLayout ? { display: 'unset' } : null} className="shop-products">
                    {products.map(product => gridLayout ? (
                        <ProductCardOverlay key={product.id} data={product} url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))}>
                            <ProductCard data={product} size="xl" url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))} />
                        </ProductCardOverlay>
                    ) : (
                            <ProductListView key={product.id} data={product} url={productUrl(product, getCategoryBySubcategory(categories, product.subcategory))} />
                        ))}
                </div>


                {!loading && products.length === 0 ? <ItemNotFound /> : null}

                {products.length >= 9 ?
                    <div className="explore-more">
                        <Button disabled={loading} onClick={exploreMore} className="explore-more-button">
                            EXPLORE MORE
                        </Button>
                    </div> : null}
            </div>
            {
            hasError ?
                <ErrorComponent message={errorMessage}></ErrorComponent>
                : null
            }   
        </div>
    </React.Fragment>
    );
}

export default Shop;