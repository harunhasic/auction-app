import BaseService from './BaseService'
import { setSession } from './CommonService';

export default class AuthService extends BaseService {

  login(params) {
    return this.authorizedApi({
      method: 'POST',
      url: '/users/login',
      data: params
    })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem('user', JSON.stringify(response.data));
        }
        setSession(response.data.person, response.data.token);
        return response.data;
      });
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(params) {
    return this.baseApi({
      method: 'POST',
      url: '/users/register',
      data: params
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}
