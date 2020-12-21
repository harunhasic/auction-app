package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.SubCategory;
import com.atlantbh.auction.model.filter.NullFilterBuilder;
import com.atlantbh.auction.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService extends BaseService<SubCategory, Long, NullFilterBuilder, SubCategoryRepository> {

    public List<SubCategory> getRandomSubcategories(int n) throws ServiceException {
        try {
            return repository.getRandomSubcategories(n);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the random subcategories", e);
        }
    }

    public List<SubCategory> getAllSubcategories() throws ServiceException {
        try {
            return repository.getSubcategories();
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the subcategories", e);
        }
    }
}
