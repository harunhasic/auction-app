package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller used for model Product request handling.
 * Main purpose is to return products.
 *
 * @author Harun Hasic
 */
@ApiOperation(value = "/products", tags = "Products entity controller")
@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<Product, Long, ProductService> {

    @ApiOperation(value = "Return random featured products")
    @GetMapping("/random/featured")
    public ResponseEntity getFeaturedRandomProducts() {
        try {
            return ResponseEntity.ok(service.getFeaturedRandomProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return new products")
    @GetMapping("/new")
    public ResponseEntity getNewProducts() {
        try {
            return ResponseEntity.ok(service.getNewProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return last chance products")
    @GetMapping("/last")
    public ResponseEntity getLastProducts() {
        try {
            return ResponseEntity.ok(service.getLastProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return top rated products")
    @GetMapping("/top")
    public ResponseEntity getTopRated() {
        try {
            return ResponseEntity.ok(service.getTopRatedProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return one product")
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getProduct(id));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return related products for a given product")
    @GetMapping("/related/{id}")
    public ResponseEntity getRelatedProducts(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(service.getRelatedProducts(id));

        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
