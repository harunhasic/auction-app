package com.atlantbh.auction.repository;

import com.atlantbh.auction.exceptions.RepositoryException;
import com.atlantbh.auction.model.BaseModel;

/**
 * The base repository interface that describes the methods
 * that will be used for database interaction.
 * Implementation of the given methods is in the BaseRepositoryImpl class.
 *
 * @param <M> represents entity/model
 * @param <I> represents models id
 * @author Harun Hasic
 */
public interface BaseRepository<M extends BaseModel<M, I>, I> {

    M save(M entity) throws RepositoryException;

    M update(M entity) throws RepositoryException;

    void deleteById(I id) throws RepositoryException;

    void delete(M obj) throws RepositoryException;

    M findById(I id);

    M get(I id) throws RepositoryException;
}
