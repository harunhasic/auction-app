package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController<Product, Long, ProductService> {


    @GetMapping("/random/featured")
    public ResponseEntity getFeaturedRandomProducts() {
        try {
            return ResponseEntity.ok(service.getFeaturedRandomProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/new")
    public ResponseEntity getNewProducts() {
        try {
            return ResponseEntity.ok(service.getNewProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/last")
    public ResponseEntity getLastProducts() {
        try {
            return ResponseEntity.ok(service.getLastProducts());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity getProduct(@RequestParam(name = "product_id") Long productId,
                                     @RequestParam(name = "user_id", defaultValue = "") Long userId) {
        try {
            return ResponseEntity.ok(service.getProduct(productId, userId));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}/related")
    public ResponseEntity getRelatedProducts(
            @PathVariable Long id,
            @RequestParam("subcategory") Long subcategoryId) {
        try {
            return ResponseEntity.ok(service.getRelatedProducts(id, subcategoryId));

        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
