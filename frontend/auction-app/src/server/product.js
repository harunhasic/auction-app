import axios from 'axios';
import { defaultHeader, getParams } from './common';
import { getUserId } from '../utils/LocalStorageUtils'

export async function getProduct(productId, userId) {
    return (await axios.get(`${process.env.REACT_APP_BACKEND_ENDPOINT}/products/?product_id=${productId}&user_id=${userId}`)).data;
};

export async function getRandomFeaturedProducts() {
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/products/random/featured')).data;
};

export async function getNewProducts() {
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/products/new')).data;
};

 export async function getLastProducts() {
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/products/last')).data;
};

export async function getRelatedProducts(id) {
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/products/related/?id=' + id)).data;
};

export async function searchProducts(query, category, subcategory, page, sort) {
    let headers;
    if (getUserId() === null)
        headers = getParams({ query, category, subcategory, page, sort });
    else
        headers = { ...defaultHeader(), ...getParams({ query, category, subcategory, page, sort }) };
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/products/search', headers)).data;
};