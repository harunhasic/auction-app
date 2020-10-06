import axios from 'axios';
import authHeader from './auth-service';



export default class BaseService {


    baseApi(params) {
        return axios.create({
            baseURL: process.env.REACT_APP_FRONTEND_ENDPOINT
        })(params);
    }

    authorizedApi(params) {
        return axios.create({
            baseURL: process.env.REACT_APP_FRONTEND_ENDPOINT,
            headers: new authHeader()
        })(params);
    }
}
