import axios from 'axios';
import authHeader from './auth-service';



export default class BaseService {


    baseApi(params) {
        return axios.create({
            baseURL: process.env.REACT_APP_BACKEND_ENDPOINT
        })(params);
    }

    getApi() {
        return axios.get({
            baseUrl: process.env.REACT_APP_BACKEND_ENDPOINT
        });
    }

    authorizedApi(params) {
        return axios.create({
            baseURL: process.env.REACT_APP_BACKEND_ENDPOINT,
            headers: new authHeader()
        })(params);
    }

    
}
