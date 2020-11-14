import axios from 'axios';
import authHeader from './auth-service';
import {authorizedApi} from './calls';

export default class BaseService {

    baseApi(params) {
        return axios.create({
            baseURL: process.env.REACT_APP_BACKEND_ENDPOINT_DEV
        })(params);
    }

    authorizedApi(params) {
        return authorizedApi(params);
    }
}
