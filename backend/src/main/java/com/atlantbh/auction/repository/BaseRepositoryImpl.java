package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.BaseModel;
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

public class BaseRepositoryImpl<M extends BaseModel<M, I>, I> implements BaseRepository<M, I> {

    @PersistenceContext
    protected EntityManager entityManager;

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
            throw new RepositoryException("There was an error while returning this user " + id, e);
        }
    }

    @Override
    @Transactional
    public M findById(I id) {
        return entityManager.find(getParameterType(), id);
    }


    @Transactional(rollbackFor = RepositoryException.class)
    public List<M> saveAll(List<M> entities) throws RepositoryException {
        try {
            entities.forEach(entity -> {
                entityManager.persist(entity);
            });
            return entities;
        } catch (Exception e) {
            throw new RepositoryException("The object could not be saved.", e);
        }
    }

    public Criteria getBaseCriteria() {
        return getSession().createCriteria(getParameterType());
    }
}



