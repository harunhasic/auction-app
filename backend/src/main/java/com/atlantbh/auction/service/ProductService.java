package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.model.filter.ProductFilterBuilder;
import com.atlantbh.auction.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, Long, ProductFilterBuilder, ProductRepository> {

    public List<Product> getFeaturedRandomProducts(int n) throws ServiceException {
        try {
            return repository.getRandomFeaturedProducts(n);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the featured products", e);
        }
    }

    public List<Product> getNewProducts(int n) throws ServiceException {
        try {
            return repository.getNewProducts(n);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the new products", e);
        }
    }

    public List<Product> getLastProducts(int n) throws ServiceException {
        try {
            return repository.getLastProducts(n);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the new products", e);
        }
    }

    public List<Product> getRelatedProducts(Long productId, int n) throws ServiceException {
        try {
            Product product = repository.findById(productId);
            return repository.getRelatedProducts(productId, product.getSubcategory().getId(), n);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the related products", e);
        }
    }

    public List<Product> getTopRatedProducts(int n) throws ServiceException {
        try {
            return repository.getTopRated(n);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the top rated products", e);
        }
    }

    public Product getProduct(Long productId) throws ServiceException {
        try {
            return repository.get(productId);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the product", e);
        }
    }

    public List<Double> getPrices() throws ServiceException {
        try {
            return repository.getPrices();
        } catch (RepositoryException e) {
            throw new ServiceException("There were issues with returning the prices of all products", e);
        }
    }
}
