import axios from 'axios';
import { getToken } from '../utils/LocalStorageUtils';

export const authorizedApi = axios.create({
    baseURL: process.env.REACT_APP_BACKEND_ENDPOINT_DEV
});

authorizedApi.interceptors.request.use(config => {
    const token = 'Bearer ' + getToken();
    config.headers['Authorization'] = token;
    return config;
});

export default authorizedApi;