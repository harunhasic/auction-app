import axios from 'axios';

export async function getRandomSubcategories() {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/subcategories/random')).data;
};

export async function getAllSubCategories() {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/subcategories/all')).data;
};