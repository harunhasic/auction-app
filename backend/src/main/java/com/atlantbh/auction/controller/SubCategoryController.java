package com.atlantbh.auction.controller;


import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.SubCategory;
import com.atlantbh.auction.service.SubCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/subcategories")
public class SubCategoryController extends BaseController<SubCategory, Long, SubCategoryService> {

    @GetMapping("/random")
    public ResponseEntity getRandomSubcategories() {
        try {
            return ResponseEntity.ok(service.getRandomSubcategories());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity getAllSubCategories() {
        try {
            return ResponseEntity.ok(service.getAllSubcategories());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
