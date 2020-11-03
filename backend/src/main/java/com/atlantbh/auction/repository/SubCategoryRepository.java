package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.SubCategory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SubCategoryRepository extends BaseRepositoryImpl<SubCategory, Long> {

    public List<SubCategory> getRandomSubcategories(int n) throws RepositoryException {
        try {
            return getBaseCriteria()
                    .add(Restrictions.sqlRestriction("1=1 order by RANDOM()"))
                    .setMaxResults(n)
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was issues with returning the random subcategories", e);
        }
    }

    public List<SubCategory> getSubcategories() throws RepositoryException {
        try {
            return getBaseCriteria()
                    .list();
        } catch (Exception e) {
            throw new RepositoryException("There was an issue with returning all subcategories");
        }
    }

    @Transactional
    public SubCategory findByName(String name) {
        return (SubCategory) getBaseCriteria()
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }
}
