package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.BaseModel;

/**
 * The base repository interface that needs to be implemented..
 *
 * @param <M> represents entity/model
 * @param <I> represents models id
 * @author Harun Hasic
 */

public interface BaseRepository<M extends BaseModel<M, I>, I> {

    M save(M entity) throws RepositoryException;

    M update(M entity) throws RepositoryException;

    void delete(I id) throws RepositoryException;

    M findById(I id);

    M get(I id) throws RepositoryException;

}
