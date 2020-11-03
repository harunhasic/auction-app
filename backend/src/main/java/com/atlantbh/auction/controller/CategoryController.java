package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Category;
import com.atlantbh.auction.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity getCategories() {
        try {
            return ResponseEntity.ok(service.findCategories());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Get category by subcategory id")
    @GetMapping("/subcategory/{id}")
    public ResponseEntity getCategoryBySubcategoryId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getCategoryBySubcategoryId(id));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
