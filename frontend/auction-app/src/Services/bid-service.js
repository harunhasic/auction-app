import BaseService from './BaseService';

export default class BidService extends BaseService {

    getBids(productId) {
        return this.baseApi({
            method: 'GET',
            url: `/bid/${productId}`
        })
    }

    addBid(params) {
        return this.authorizedApi({
            method: 'POST',
            url: `/bid/add`,
            data: params
        })
            .then(response => {
                return response.data;
            });
    }

    getHighestBid(productId) {
        return this.baseApi({
            method: 'GET',
            url: `/bid/highest/${productId}`
        })
    }
}