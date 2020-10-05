import BaseService from './BaseService'
import { setSession, removeSession } from '../utils/LocalStorageUtils';

export default class AuthService extends BaseService {

  login(params) {
    return this.authorizedApi({
      method: 'POST',
      url: '/api/users/login',
      data: params
    })
      .then(response => {
        if (response.data.accessToken) {
          
        }
        setSession(JSON.stringify(response.data), response.data.token);
        return response.data;
      });
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(params) {
    return this.baseApi({
      method: 'POST',
      url: '/api/users/register',
      data: params
    });
  }

  getUser() {
    const user = localStorage.getItem('user');
    return user ? JSON.parse(user) : null;
};

  authHeader() {
    const user = JSON.parse(localStorage.getItem('user'));

    if (user && user.accessToken) {
      return { Authorization: 'Bearer ' + user.accessToken };
    } else {
      return {};
    }
  }
}
