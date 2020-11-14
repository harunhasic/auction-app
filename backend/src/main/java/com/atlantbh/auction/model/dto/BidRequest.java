package com.atlantbh.auction.model.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class BidRequest {

    @NotNull(message = "The bid offer cannot be null")
    @DecimalMin(value = "00.50", message = "The minimum bid offer cannot be less than 00.50")
    private double price;

    @NotNull(message = "The product id must be valid")
    private Long productId;

    @NotNull(message = "The user id must be valid")
    private Long userId;

    public BidRequest(double price, Long productId, Long userId) {
        this.price = price;
        this.productId = productId;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
