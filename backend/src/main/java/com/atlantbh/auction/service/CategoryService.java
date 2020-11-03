package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Category;
import com.atlantbh.auction.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {

    public List<Category> findCategories() throws ServiceException {
        try {
            return repository.getAll();
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning all the categories", e);
        }
    }

    public Category getCategoryBySubcategoryId(Long id) throws ServiceException {
        try {
            return repository.getCategoryBySubcategoryId(id);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the category with this subcategory id " + id, e);
        }
    }
}
