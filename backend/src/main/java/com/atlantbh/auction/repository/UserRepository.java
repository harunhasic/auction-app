package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.User;
import com.atlantbh.auction.model.filter.NullFilterBuilder;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Repository that handles the User model database interaction.
 *
 * @author Harun Hasic
 */
@Repository
public class UserRepository extends BaseRepositoryImpl<User, Long, NullFilterBuilder> {

    @Transactional
    public Optional<User> findByEmail(String email) throws RepositoryException {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> q = cb.createQuery(User.class);
            Root<User> resource = q.from(User.class);
            q.select(resource);
            Predicate predicateForEmail = cb.equal(resource.get("email"), email);
            q.where(predicateForEmail);

            User user = entityManager.createQuery(q).getSingleResult();
            if (user != null) {
                return Optional.of(user);
            } else
                return Optional.empty();
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Transactional
    public User findByFirstName(String name) {
        return (User) getBaseCriteria()
                .add(Restrictions.eq("firstName", name))
                .uniqueResult();
    }
}
