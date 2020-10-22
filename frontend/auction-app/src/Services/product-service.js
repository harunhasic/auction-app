import BaseService from './BaseService'


export default class ProductService extends BaseService {

    getRandomProducts() {
        return this.baseApi({
            method: 'GET',
            url: '/products/random/featured'
        });
    }

    getNewProducts() {
        return this.baseApi({
            method: 'GET',
            url: '/products/new'
        });
    }

    getTopRatedProducts() {
        return this.baseApi({
            method: 'GET',
            url: '/products/top'
        });
    }

    getProduct(productId) {
        return this.baseApi({
            method: 'GET',
            url: `/products/${productId}`
        });
    }
    getLastProducts() {
        return this.baseApi({
            method: 'GET',
            url: '/products/last'
        });
    }

    getRelatedProducts(productId) {
        return this.baseApi({
            method: 'GET',
            url: `/products/related/${productId}`
        });
    }
}
