package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends BaseService<Product, Long, ProductRepository> {

    public List<Product> getFeaturedRandomProducts() throws ServiceException {
        try {
            return repository.getRandomFeaturedProducts();
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the featured products", e);
        }
    }

    public List<Product> getNewProducts() throws ServiceException {
        try {
            return repository.getNewProducts();
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the new products", e);
        }
    }

    public List<Product> getLastProducts() throws ServiceException {
        try {
            return repository.getLastProducts();
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the new products", e);
        }
    }

    public List<Product> getRelatedProducts(Long productId) throws ServiceException {
        try {
            Product product = repository.findById(productId);
            List<Product> products = repository.getRelatedProducts(productId, product.getSubcategory().getId());
            return products;
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the related products", e);
        }
    }

    public List<Product> getTopRatedProducts() throws ServiceException {
        try {
            return repository.getTopRated();
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the top rated products", e);
        }
    }

    public Product getProduct(Long productId) throws ServiceException {
        try {
            Product product = repository.getProduct(productId);
            return product;
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the product", e);
        }
    }
}
