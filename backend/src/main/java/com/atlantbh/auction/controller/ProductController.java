package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/random/featured/{n}")
    public ResponseEntity getFeaturedRandomProducts(@PathVariable int n) {
        try {
            return ResponseEntity.ok(service.getFeaturedRandomProducts(n));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return new products")
    @GetMapping("/new/{n}")
    public ResponseEntity getNewProducts(@PathVariable int n) {
        try {
            return ResponseEntity.ok(service.getNewProducts(n));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return last chance products")
    @GetMapping("/last/{n}")
    public ResponseEntity getLastProducts(@PathVariable int n) {
        try {
            return ResponseEntity.ok(service.getLastProducts(n));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return top rated products")
    @GetMapping("/top/{n}")
    public ResponseEntity getTopRated(@PathVariable int n) {
        try {
            return ResponseEntity.ok(service.getTopRatedProducts(n));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @ApiOperation(value = "Return one product")
    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable Long id) {
        return this.get(id);
    }

    @ApiOperation(value = "Return related products for a given product")
    @GetMapping("/related/{id}/{n}")
    public ResponseEntity getRelatedProducts(@PathVariable Long id, @PathVariable int n) {
        try {
            return ResponseEntity.ok(service.getRelatedProducts(id, n));
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
