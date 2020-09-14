package com.atlantbh.auction.controller;

import com.atlantbh.auction.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



public abstract class BaseController<T> {

    @Autowired
    private final BaseService<T> baseService;

    public BaseController(BaseService<T> baseService){
        this.baseService = baseService;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public T read(@PathVariable Long id) {
        return baseService.getById(id);
    }

}
