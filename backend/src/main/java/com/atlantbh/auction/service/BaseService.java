package com.atlantbh.auction.service;

import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> {
    T getById(Long requestId);

}