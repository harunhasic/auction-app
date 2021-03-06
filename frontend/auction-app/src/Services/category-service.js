import BaseService from './BaseService'

export default class CategoryService extends BaseService {
    
    getCategories() {
        return this.baseApi({
            method: 'GET',
            url: '/categories'
        });
    }

    getBySubcategoryId(id) {
        return this.baseApi({ 
            method: 'GET',
            url: `/categories/subcategory/${id}`
        });
    }

    getByName(name) {
        return this.baseApi({
            method: 'GET',
            url: `/categories/${name}`
        })
    }
}

