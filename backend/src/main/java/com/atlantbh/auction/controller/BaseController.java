package com.atlantbh.auction.controller;


import com.atlantbh.auction.model.BaseModel;
import com.atlantbh.auction.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


public abstract class BaseController<M extends BaseModel<M, I>,I , S extends BaseService<M, I, ?>>{


    private BaseService<M, I, S> baseService;

    @Autowired
    private void setBaseService(BaseService baseService){
        this.baseService=baseService;
    }


    @PostMapping
    @ResponseBody
    public ResponseEntity<M> create(@RequestBody M obj) {
       baseService.create(obj);
        return new ResponseEntity<M>(obj, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<M>getById(@PathVariable I id) {
        return ResponseEntity.ok(baseService.getById(id));
    }
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<M>> getAll() {
        return ResponseEntity.ok(baseService.getAll());
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<M> deleteById( M obj) {
       baseService.delete(obj);
       return new ResponseEntity<M>(obj, HttpStatus.ACCEPTED);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity<M> update(@RequestBody M obj){
       return ResponseEntity.ok(baseService.update(obj));
    }



}
