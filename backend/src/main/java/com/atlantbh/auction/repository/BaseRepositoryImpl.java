package com.atlantbh.auction.repository;

import com.atlantbh.auction.model.BaseModel;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;



public  class BaseRepositoryImpl<M extends BaseModel<M,I>,I> implements BaseRepository<M , I> {

    @PersistenceContext
    private EntityManager entityManager;

    protected Class<M> entityClass;

   public BaseRepositoryImpl(Class<M> entityClass){
       this.entityClass=entityClass;
    }


    public Class<M> getEntityClass() {
        return entityClass;
    }
    public void setEntityClass(Class<M> entityClass) {
        this.entityClass = entityClass;
    }
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    @Transactional
    public void add(M entityClass) {
       entityManager.persist(entityClass);
    }

    @Override
    @Transactional
    public M update(M obj) {
        return entityManager.merge(obj);

    }

    @Override
    @Transactional
    public void delete(M obj) {
        entityManager.remove(entityManager.contains(obj) ? obj : entityManager.merge(obj));
    }

    @Override
    @Transactional
    public M get(I id) {
       return entityManager.find(entityClass,id);
    }

    @Override
    @Transactional
    public List<M> getAll() {
        return entityManager.createQuery("Select m from " + entityClass.getSimpleName() + " m").getResultList();
    }
    }


