package com.atlantbh.auction.controller;

import com.atlantbh.auction.model.Category;
import com.atlantbh.auction.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category, Long, CategoryService> {

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(service.findCategories());
    }

}
