package com.atlantbh.auction.repository;

import com.atlantbh.auction.model.Category;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CategoryRepository extends BaseRepositoryImpl<Category, Long> {

    public List<Category> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Category c");
        return query.getResultList();
    }
}

