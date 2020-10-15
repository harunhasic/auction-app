import axios from 'axios';

export async function getRandomSubcategories() {
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/subcategories/random')).data;
};

export async function getAllSubCategories() {
    return (await axios.get(process.env.REACT_APP_BACKEND_ENDPOINT + '/subcategories/all')).data;
};