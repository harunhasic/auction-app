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

    getProduct(productId, userId) {
        return this.baseApi({
            method: 'GET',
            url: `/products/?product_id=${productId}&user_id=${userId}`
        });
    }
    getLastProducts() {
        return this.baseApi({
            method: 'GET',
            url: '/products/last'
        });
    }

    getRelatedProducts(id) {
        return this.baseApi({
            method: 'GET',
            url: '/products/related/?id=' + id
        });
    }
}
