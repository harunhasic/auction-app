import axios from 'axios';

export const getProduct = async (productId, userId) => {
    return (await axios.get(`${process.env.REACT_APP_FRONTEND_ENDPOINT}/products/?product_id=${productId}&user_id=${userId}`)).data;
};

export async function getRandomFeaturedProducts() {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/random/featured')).data;
};

export async function getNewProducts() {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/new')).data;
};

export async function getLastProducts() {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/last')).data;
};

export async function getRelatedProducts(id) {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/related/?id=' + id)).data;
};
