package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.BaseModel;
import com.atlantbh.auction.model.PaginatedResult;
import com.atlantbh.auction.model.filter.BaseFilterBuilder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Implementation of the base repository interface. It is used
 * for database interaction.
 *
 * @param <M> represents entity/model
 * @param <I> represents models id
 * @author Harun Hasic
 */
public class BaseRepositoryImpl<M extends BaseModel<M, I>, I, F extends BaseFilterBuilder<?, F>> implements BaseRepository<M, I, F> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<M> getParameterType() {
        return (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public Criteria getBaseCriteria() {
        return getSession().createCriteria(getParameterType());
    }

    @Override
    @Transactional
    public M save(M entity) throws RepositoryException {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity;
        } catch (Exception e) {
            throw new RepositoryException("The object could not be saved.", e);
        }
    }

    @Override
    @Transactional
    public M update(M entity) throws RepositoryException {
        try {
            entityManager.merge(entity);
            entityManager.flush();
            return entity;
        } catch (Exception e) {
            throw new RepositoryException("This object could not be updated " + entity.getId(), e);
        }
    }

    @Override
    @Transactional
    public void deleteById(I id) throws RepositoryException {
        try {
            M obj = findById(id);
            getSession().delete(obj);
        } catch (Exception e) {
            throw new RepositoryException("There was an error while deleting user  with id " + id, e);
        }
    }

    @Override
    @Transactional
    public void delete(M obj) throws RepositoryException {
        try {
            getSession().delete(obj);
        } catch (Exception e) {
            throw new RepositoryException("There was a problem with the deletion of this user", e);
        }
    }

    @Override
    @Transactional
    public M get(I id) throws RepositoryException {
        try {
            return entityManager.find(getParameterType(), id);
        } catch (Exception e) {
            throw new RepositoryException("There was an error while returning the entity with this id " + id, e);
        }
    }

    @Override
    @Transactional
    public M findById(I id) {
        return entityManager.find(getParameterType(), id);
    }

    //TODO - Delete this method when there is no use for it.
    @Transactional(rollbackFor = RepositoryException.class)
    public List<M> saveAll(List<M> entities) throws RepositoryException {
        try {
            entities.forEach(entity -> {
                getSession().persist(entity);
                getSession().flush();
            });
            return entities;
        } catch (Exception e) {
            throw new RepositoryException("The object could not be saved.", e);
        }
    }

    @Override
    @Transactional
    public PaginatedResult<M> find(F filterBuilder) {
        PaginatedResult<M> paginatedResult = new PaginatedResult<>();
        paginatedResult.setPageNumber(filterBuilder.getPageNumber());
        paginatedResult.setPageSize(filterBuilder.getPageSize());
        paginatedResult.setData(filterBuilder.buildCriteria(getBaseCriteria()).list());
        paginatedResult.setAvailable(Math.toIntExact(count(filterBuilder)));
        return paginatedResult;
    }

    private Long count(F filterBuilder) {
        Long count = (Long) filterBuilder.buildCountCriteria(getBaseCriteria()).uniqueResult();
        return count == null ? 0 : count;
    }
}



