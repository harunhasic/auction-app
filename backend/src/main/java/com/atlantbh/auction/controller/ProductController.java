package com.atlantbh.auction.controller;

import com.atlantbh.auction.exceptions.ServiceException;
import com.atlantbh.auction.model.Product;
import com.atlantbh.auction.model.enums.ProductSortKeys;
import com.atlantbh.auction.model.filter.ProductFilterBuilder;
import com.atlantbh.auction.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.EnumUtils;
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
@CrossOrigin
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

    @ApiOperation(value = "Method for filtering the products on the page")
    @GetMapping("/filter")
    public ResponseEntity filter(@RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "1") Integer pageNumber,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Double minPrice,
                                 @RequestParam(required = false) Double maxPrice,
                                 @RequestParam(required = false) String color,
                                 @RequestParam(required = false) String size,
                                 @RequestParam(required = false) String sortKey,
                                 @RequestParam(required = false) Boolean ascending,
                                 @RequestParam(required = false) String subCategory,
                                 @RequestParam(required = false) String category) {
        ProductFilterBuilder productFilterBuilder = new ProductFilterBuilder()
                .setMinPrice(minPrice)
                .setMaxPrice(maxPrice)
                .setName(name)
                .setPageNumber(pageNumber)
                .setColor(color)
                .setSize(size)
                .setPageSize(pageSize)
                .setSortKey(EnumUtils.getEnum(ProductSortKeys.class, sortKey))
                .setSortAsc(ascending)
                .setSubCategory(subCategory)
                .setCategory(category);
        return ResponseEntity.ok(service.find(productFilterBuilder));
    }

    @ApiOperation(value = "Return related products for a given product")
    @GetMapping("/prices")
    public ResponseEntity getPrices() {
        try {
            return ResponseEntity.ok(service.getPrices());
        } catch (ServiceException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
