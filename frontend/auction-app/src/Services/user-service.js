import BaseService from './BaseService'
import axios from 'axios';

export default class UserService extends BaseService {

  getPublicContent() {
    return axios.get(this.BASE_URL + '');
  }

  getUserBoard() {
    return this.authorizedApi({
      method: 'GET',
      url: '/user'
    });
  }
}
