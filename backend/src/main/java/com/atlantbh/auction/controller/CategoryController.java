package com.atlantbh.auction.controller;

import com.atlantbh.auction.model.Category;
import com.atlantbh.auction.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller used for model Category request handling.
 * Main purpose is to return the categories.
 *
 * @author Harun Hasic
 */
@ApiOperation(value = "/categories", tags = "Categories entity controller")
@RestController
@RequestMapping("/categories")
public class CategoryController extends BaseController<Category, Long, CategoryService> {

    @ApiOperation(value = "Return all categories")
    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(service.findCategories());
    }

}
