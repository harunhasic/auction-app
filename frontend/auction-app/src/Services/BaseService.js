import axios from 'axios';
import authHeader from './auth-header';


export default class BaseService {

    baseApi(params) {
        return axios.create({
            baseURL: 'http://localhost:8080/api'
        })(params);
    }

    authorizedApi(params) {
        return axios.create({
            baseURL: 'http://localhost:8080/api',
            headers: authHeader()
        })(params);
    }
}


