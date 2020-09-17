package com.atlantbh.auction.repository;

import java.util.List;

public interface BaseRepository<M, I> {
    public void add(M entityClass);
    public M update(M entityClass);
    public void delete(M obj);
    public M get(I id);
    public List<M> getAll();
}
