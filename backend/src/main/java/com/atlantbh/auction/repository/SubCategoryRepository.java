package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.SubCategory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubCategoryRepository extends BaseRepositoryImpl<SubCategory, Long> {

    public List<SubCategory> getRandomSubcategories() throws RepositoryException {
        try {
            List<SubCategory> randomSubcategories = getBaseCriteria()
                    .add(Restrictions.sqlRestriction("1=1 order by RANDOM()"))
                    .setMaxResults(3)
                    .list();
            return randomSubcategories;
        } catch (Exception e) {
            throw new RepositoryException("There was issues", e);
        }
    }

    public List<SubCategory> getSubcategories() throws RepositoryException {
        try {
            List<SubCategory> getSubcategories = getBaseCriteria()
                    .list();
            return getSubcategories;
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning all subcategories");
        }
    }
}
