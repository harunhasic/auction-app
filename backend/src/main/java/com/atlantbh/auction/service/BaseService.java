package com.atlantbh.auction.service;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.BaseModel;
import com.atlantbh.auction.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * The base service for bussiness logic, all other services will extend this one..
 *
 * @author Harun Hasic
 */

public class BaseService<M extends BaseModel<M, I>, I, R extends BaseRepository<M, I>> {

    @Autowired
    protected R repository;

    public M getById(I requestId) throws ServiceException {
        try {
            return repository.get(requestId);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while accessing this id" + requestId);
        }

    }

    public M create(M entity) throws ServiceException {
        try {
            return repository.save(entity);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while creating this user");
        }
    }

    public M update(M entity) throws ServiceException {
        try {
            return repository.update(entity);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while updating the user with this id" + entity.getId());
        }
    }

    public void delete(I id) throws ServiceException {
        try {
            repository.delete(id);
        } catch (RepositoryException e) {
            throw new ServiceException("There was an error while trying to delete an user with this id" + id);
        }
    }

}