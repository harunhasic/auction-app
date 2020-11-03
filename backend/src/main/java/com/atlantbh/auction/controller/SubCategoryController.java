package com.atlantbh.auction.controller;


import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.SubCategory;
import com.atlantbh.auction.service.SubCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller used for model SubCategory request handling.
 * Main purpose is to return the subcategories.
 *
 * @author Harun Hasic
 */
@ApiOperation(value = "/subcategories", tags = "Subcategories entity controller")
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController extends BaseController<SubCategory, Long, SubCategoryService> {

    @ApiOperation(value = "Return random subcategories")
    @GetMapping("/random/{n}")
    public ResponseEntity getRandomSubcategories(@PathVariable int n) {
        try {
            return ResponseEntity.ok(service.getRandomSubcategories(n));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return all subcategories")
    @GetMapping("/all")
    public ResponseEntity getAllSubCategories() {
        try {
            return ResponseEntity.ok(service.getAllSubcategories());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
