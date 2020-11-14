package com.atlantbh.auction.model;

import org.apache.commons.lang3.NotImplementedException;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "bid")
public class Bid extends BaseModel<Bid, Long> {

    @CreationTimestamp
    private Date bidDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bidder_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", updatable = false)
    private Product product;

    @NotNull
    private double amount;

    public Bid() {

    }

    public Bid(Date bidDate, User user, Product product, double amount) {
        this.bidDate = bidDate;
        this.user = user;
        this.product = product;
        this.amount = amount;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User bidder) {
        this.user = bidder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double bid) {
        this.amount = bid;
    }

    @Override
    public void update(Bid model) {
        user = model.user;
        amount = model.amount;
        product = model.product;
        bidDate = model.bidDate;
    }

    @Override
    public Bid duplicate(Bid obj) throws NotImplementedException {
        throw new NotImplementedException("The duplicate method is not implemented for the Bid model");
    }
}
