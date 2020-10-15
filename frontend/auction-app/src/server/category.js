import axios from 'axios';

export async function getCategories() {
    return (await axios.get(process.env.REACT_APP_FRONTEND_ENDPOINT + '/categories')).data;
};