import BaseService from './BaseService'
import axios from 'axios';

export default class UserService extends BaseService {

  getByMail(email) {
    return this.authorizedApi({
      method: 'GET',
      url: '/api/users/' + email
    });
  }

}
