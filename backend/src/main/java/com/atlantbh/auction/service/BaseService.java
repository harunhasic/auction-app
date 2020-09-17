package com.atlantbh.auction.service;

import java.util.List;



public abstract class BaseService<M ,I,R> {

    public abstract M getById(I requestId);

    public abstract void create(M obj);

    public abstract M update(M obj);

    public abstract void delete(M obj);

    public abstract List<M> getAll();
}