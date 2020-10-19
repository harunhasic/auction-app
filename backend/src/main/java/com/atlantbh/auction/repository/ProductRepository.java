package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.Product;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class ProductRepository extends BaseRepositoryImpl<Product, Long> {

    public List<Product> getRandomFeaturedProducts() throws RepositoryException {
        try {
            List<Product> randomProducts = getBaseCriteria()
                    .add(Restrictions.sqlRestriction("1=1 order by RANDOM()"))
                    .setMaxResults(5)
                    .list();
            return randomProducts;
        } catch (Exception e) {
            throw new RepositoryException("There was issues", e);
        }
    }

    public List<Product> getNewProducts() throws RepositoryException {
        try {
            Criteria criteria = getBaseCriteria();
            criteria.addOrder(Order.desc("startDate"));
            criteria.setMaxResults(12);
            List<Product> newProducts = criteria.list();
            return newProducts;
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the new products", e);
        }
    }

    public List<Product> getRelatedProducts(Long productId, Long subcategoryId) throws RepositoryException {
        try {
            Criteria criteria = getBaseCriteria().createAlias("subCategory", "s");
            criteria.add(Restrictions.eq("s.id", subcategoryId));
            List<Product> relatedProducts = criteria.list();
            return relatedProducts;
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the related products", e);
        }
    }

    public List<Product> getLastProducts() throws RepositoryException {
        try {
            Criteria criteria = getBaseCriteria();
            criteria.addOrder(Order.desc("endDate"));
            criteria.setMaxResults(12);
            List<Product> lastProducts = criteria.list();
            return lastProducts;
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the last chance products", e);
        }
    }

    public List<Product> getTopRated() throws RepositoryException {
        try {
            Criteria criteria = getBaseCriteria();
            criteria.addOrder(Order.asc("rating"));
            criteria.setMaxResults(12);
            List<Product> bestRated = criteria.list();
            return bestRated;
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the top rated products", e);
        }
    }

    public List<Product> getProduct(@Param("product_id") Long productId, @Param("user_id") Long userId) throws RepositoryException {
        try {
            Query getProduct = getSession().createNativeQuery("SELECT p.id, p.person_id personId, p.name, p.description, p.start_price startPrice, " +
                    "p.start_date startDate, p.end_date endDate, " +
                    "EXISTS(SELECT * FROM wishlist " +
                    "WHERE product_id = :product_id AND person_id = :user_id) wished, " +
                    "ph.id photoId, ph.url photoUrl, ph.featured photoFeatured " +
                    "FROM product p LEFT OUTER JOIN photo ph on p.id = ph.product_id " +
                    "WHERE p.id = :product_id " +
                    "ORDER BY ph.featured DESC");
            List<Product> product = getProduct.getResultList();
            return product;
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning the product", e);
        }
    }

    @Transactional
    public List<Product> findAll() {
        Query query = entityManager.createQuery("SELECT p FROM Product p");
        return query.getResultList();
    }
}
