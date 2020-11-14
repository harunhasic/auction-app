package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.Product;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository extends BaseRepositoryImpl<Product, Long> {

    public List<Product> getRandomFeaturedProducts(int n) throws RepositoryException {
        try {
            return getBaseCriteria()
                    .add(Restrictions.sqlRestriction("1=1 order by RANDOM()"))
                    .setMaxResults(n)
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was issues with returning the random product", e);
        }
    }

    public List<Product> getNewProducts(int n) throws RepositoryException {
        try {
            return getBaseCriteria()
                    .addOrder(Order.desc("startDate"))
                    .setMaxResults(n)
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the new products", e);
        }
    }

    public List<Product> getRelatedProducts(Long productId, Long subcategoryId, int n) throws RepositoryException {
        try {
            return getBaseCriteria().createAlias("subCategory", "s")
                    .add(Restrictions.eq("s.id", subcategoryId))
                    .add(Restrictions.ne("id", productId))
                    .setMaxResults(n)
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the related products for this product id and subcategory id" + productId + " " + subcategoryId, e);
        }
    }

    public List<Product> getLastProducts(int n) throws RepositoryException {
        try {
            return getBaseCriteria()
                    .addOrder(Order.desc("endDate"))
                    .setMaxResults(n)
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the last chance products", e);
        }
    }

    public List<Product> getTopRated(int n) throws RepositoryException {
        try {
            return getBaseCriteria()
                    .addOrder(Order.asc("rating"))
                    .setMaxResults(n)
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the top rated products", e);
        }
    }

    @Transactional
    public Product findByName(String name) {
        return (Product) getBaseCriteria()
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }
}
