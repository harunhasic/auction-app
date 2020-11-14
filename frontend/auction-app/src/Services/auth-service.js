import BaseService from './BaseService'
import { setSession, removeSession } from '../utils/LocalStorageUtils';

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

  authHeader() {
    const user = JSON.parse(localStorage.getItem('auctionapp-user'));
    if (user && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken };
    } else {
      return {};
    }
  }
}
