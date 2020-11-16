import BaseService from './BaseService'
import { setSession } from '../utils/LocalStorageUtils';

export default class AuthService extends BaseService {

  login(params) {
    return this.baseApi({
      method: 'POST',
      url: '/api/users/login',
      data: params
    })
      .then(response => {
        setSession(JSON.stringify(response.data), response.data.token);
        return response.data;
      });
  }

  register(params) {
    return this.baseApi({
      method: 'POST',
      url: '/api/users/register',
      data: params
    });
  }
}
