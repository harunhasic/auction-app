package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.BaseModel;
import com.atlantbh.auction.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generic service used for defining business logic methods.
 *
 * @author Harun Hasic
 */
public class BaseService<M extends BaseModel<M, I>, I, R extends BaseRepository<M, I>> {

    @Autowired
    protected R repository;

    public M get(I requestId) throws ServiceException {
        try {
            return repository.get(requestId);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while accessing this id " + requestId, e);
        }

    }

    public M create(M entity) throws ServiceException {
        try {
            return repository.save(entity);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while creating this user", e);
        }
    }

    public M update(I id, M entity) throws ServiceException {
        try {
            M toUpdate = get(id);
            entity.update(toUpdate);
            repository.update(toUpdate);
            return toUpdate;
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while updating the user with this id " + entity.getId(), e);
        }
    }

    public void delete(I id) throws ServiceException {
        try {
            repository.deleteById(id);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while trying to delete an user with this id " + id, e);
        }
    }

    public M findById(I id) {
        return repository.findById(id);
    }
}