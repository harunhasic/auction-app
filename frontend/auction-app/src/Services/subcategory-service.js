import BaseService from './BaseService'
 

export default class SubCategoryService extends BaseService {

     getRandomSubCategories() {
        return this.baseApi({
            method: 'GET',
            url: '/subcategories/random'
        });
    }

    getAllSubCategories() {
        return this.baseApi({
            method: 'GET',
            url: '/subcategories/all'
        })
    }

}