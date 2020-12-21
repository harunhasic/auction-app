package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.Category;
import com.atlantbh.auction.model.SubCategory;
import com.atlantbh.auction.model.filter.NullFilterBuilder;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository extends BaseRepositoryImpl<Category, Long, NullFilterBuilder> {

    public List<Category> getAll() throws RepositoryException {
        try {
            return getBaseCriteria()
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning all the categories", e);
        }
    }

    public Category getCategoryBySubcategoryId(Long id) throws RepositoryException {
        try {
            return (Category) getBaseCriteria()
                    .createAlias("subcategories", "subcategory")
                    .add(Restrictions.eq("subcategory.id", id))
                    .uniqueResult();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the category with this subcategory id " + id, e);
        }
    }

    public Category getByName(String name) throws RepositoryException {
        try {
            return (Category) getBaseCriteria()
                    .add(Restrictions.eq("name", name))
                    .uniqueResult();
        } catch (Exception e) {
            throw new RepositoryException("There was issues with finding a product with given name", e);
        }
    }

}

