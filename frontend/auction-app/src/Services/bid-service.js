import BaseService from './BaseService';

export default class BidService extends BaseService {

    getBids(id) {
        return this.baseApi({
            method: 'GET',
            url: `/bid/${id}`
        })
    }  

    addBid(params) {
        console.log(params)
        return this.authorizedApi({
            method: 'POST',
            url: `/bid/add`,
            data: params
        })
        .then(response => {        
            return response.data;
          });
      }
    
}