import BaseService from './BaseService'

export default class ProductService extends BaseService {

    getRandomProducts(n) {
        return this.baseApi({
            method: 'GET',
            url: `/products/random/featured/${n}`
        });
    }

    getNewProducts(n) {
        return this.baseApi({
            method: 'GET',
            url: `/products/new/${n}`
        });
    }

    getTopRatedProducts(n) {
        return this.baseApi({
            method: 'GET',
            url: `/products/top/${n}`
        });
    }

    getProduct(productId) {
        return this.baseApi({
            method: 'GET',
            url: `/products/${productId}`
        });
    }

    getLastProducts(n) {
        return this.baseApi({
            method: 'GET',
            url: `/products/last/${n}`
        });
    }

    getRelatedProducts(productId, n) {
        return this.baseApi({
            method: 'GET',
            url: `/products/related/${productId}/${n}`
        });
    }
}
