package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.BaseModel;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * The base repository implementation used for data handling and db interaction
 *
 * @param <M> represents entity/model
 * @param <I> represents models id
 * @author Harun Hasic
 */

public class BaseRepositoryImpl<M extends BaseModel<M, I>, I> implements BaseRepository<M, I> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<M> getParameterType() {
        return (Class<M>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public M save(M entity) throws RepositoryException {
        try {
            entityManager.persist(entity);
            entityManager.flush();
            return entity;
        } catch (Exception e) {
            throw new RepositoryException("The object could not be saved.");
        }
    }

    @Override
    @Transactional
    public M update(M obj) throws RepositoryException {
        try {
            entityManager.merge(obj);
            entityManager.flush();
            return obj;
        } catch (Exception e) {
            throw new RepositoryException("This object could not be updated " + obj.getId());
        }
    }

    @Override
    @Transactional
    public void delete(I id) throws RepositoryException {
        try {
            M obj = findById(id);
            getSession().delete(obj);
        } catch (Exception e) {
            throw new RepositoryException("There was an error while deleting this user " + id);
        }
    }

    @Override
    @Transactional
    public M get(I id) throws RepositoryException {
        try {
            return entityManager.find(getParameterType(), id);
        } catch (Exception e) {
            throw new RepositoryException("There was an error while returning this user" + id);
        }
    }

    @Override
    @Transactional
    public M findById(I id) {
        return entityManager.find(getParameterType(), id);
    }

}


