import BaseService from './BaseService'
 
export default class SubCategoryService extends BaseService {

     getRandomSubCategories(n) {
        return this.baseApi({
            method: 'GET',
            url: `/subcategories/random/${n}`
        });
    }

    getAllSubCategories() {
        return this.baseApi({
            method: 'GET',
            url: '/subcategories/all'
        })
    }

    getSubcategoriesByCategoryId(id) {
        return this.baseApi({
            method: 'GET',
            url: `/subcategories/${id}`
        });
    }
}