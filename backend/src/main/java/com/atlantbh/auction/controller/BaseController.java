package com.atlantbh.auction.controller;


import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.BaseModel;
import com.atlantbh.auction.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

/**
 * Main generic controller used for handling requests.
 * Other model classes will extend this class and use it for their own requests.
 *
 * @author Harun Hasic
 */
public abstract class BaseController<M extends BaseModel<M, I>, I, S extends BaseService<M, I, ?>> {

    @Autowired
    protected S service;

    public void setService(S service) {
        this.service = service;
    }

    @Transactional
    public ResponseEntity create(@RequestBody M obj) {
        try {
            return ResponseEntity.ok(service.create(obj));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ResponseEntity get(@PathVariable("id") I id) {
        try {
            return ResponseEntity.ok(service.getById(id));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity delete(@PathVariable I id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Transactional
    public ResponseEntity update(@RequestBody M obj, I id) {
        try {
            return ResponseEntity.ok(service.update(id, obj));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
