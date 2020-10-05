import axios from 'axios';



export const getCategories = async () => {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/categories')).data;
};

export const getRandomSubcategories = async () => {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/subcategories/random')).data;
};

export const getRandomFeaturedProducts = async () => {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/featured/random')).data;
};

export const getNewProducts = async () => {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/new')).data;
};

export const getLastProducts = async () => {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/products/last')).data;
};

export const getProduct = async (productId, userId) => {
    return (await axios.get(`${process.env.REACT_APP_FRONTEND_ENDPOINT}/products/?product_id=${productId}&user_id=${userId}`)).data;
};