package com.atlantbh.auction.controller;


import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.BaseModel;
import com.atlantbh.auction.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

/**
 * main generic controller used for handling requests..
 *
 * @author Harun Hasic
 */


public abstract class BaseController<M extends BaseModel<M, I>, I, S extends BaseService<M, I, ?>> {

    @Autowired
    protected S service;

    private void setService(S service) {
        this.service = service;
    }

    @Transactional
    @PostMapping
    @ResponseBody
    public ResponseEntity create(@RequestBody M obj) {
        try {
            return ResponseEntity.ok(service.create(obj));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getById(@PathVariable("id") I id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @Transactional
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable I id) {
        try {
            service.delete(id);
            return new ResponseEntity<M>(HttpStatus.ACCEPTED);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody M obj) {
        try {
            return ResponseEntity.ok(service.update(obj));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
