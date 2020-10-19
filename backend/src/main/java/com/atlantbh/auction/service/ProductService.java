package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.model.dto.ProductDto;
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

    public List<Product> getRelatedProducts(Long productId, Long subcategoryId) throws ServiceException {
        try {
            List<Product> products = repository.getRelatedProducts(productId, subcategoryId);
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

    public ProductDto getProduct(Long productId, Long userId) throws ServiceException {
        try {
            List<Product> product = repository.getProduct(productId, userId);
            ProductDto productDto = new ProductDto(
                    product.get(0).getId(),
                    product.get(0).getName(),
                    product.get(0).getDescription(),
                    product.get(0).getStartPrice(),
                    product.get(0).getSubcategory(),
                    product.get(0).getStartDate(),
                    product.get(0).getEndDate(),
                    product.get(0).getPhotos(),
                    product.get(0).getUser()
            );
            return productDto;
        } catch (RepositoryException e) {
            throw new ServiceException("There was an issue with returning the prodcut", e);
        }
    }
}
