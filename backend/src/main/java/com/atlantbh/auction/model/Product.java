package com.atlantbh.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "products")
@SqlResultSetMapping(
        name = "randomFeaturedProducts",
        entities = @EntityResult(
                entityClass = Product.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "description", column = "description"),
                        @FieldResult(name = "endDate", column = "end_date"),
                        @FieldResult(name = "startDate", column = "start_date"),
                        @FieldResult(name = "numberOfBids", column = "number_of_bids"),
                        @FieldResult(name = "highestBid", column = "highest_bid"),
                        @FieldResult(name = "phone", column = "phone"),
                        @FieldResult(name = "shipping", column = "shipping"),
                        @FieldResult(name = "startPrice", column = "start_price"),
                        @FieldResult(name = "featured", column = "featured")
                }))
public class Product extends BaseModel<Product, Long> {

    @Column(name = "name")
    private String name;
    @Column(length = 4000, columnDefinition = "text", name = "description")
    private String description;
    @Column(name = "start_price")
    private double startPrice;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;

    @Column(nullable = false, name = "shipping")
    private Boolean shipping = false;

    @Column(name = "phone")
    private String phone;
    @Column(name = "highest_bid")
    private double highestBid;
    @Column(name = "number_of_bids")
    private int numberOfBids;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Photo> photos;

    @Column(name = "featured")
    private Boolean featured = false;

    @Column(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnoreProperties({"password", "firstName", "lastName", "gender", "birthDate", "phoneNumber", "address"})
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subcategory_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubCategory subCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rating rating;


    public Product() {

    }

    public Product(String name, String description, Double startPrice, Date startDate, Date endDate, boolean shipping, String phone, Double highestBid, User user, SubCategory subCategory) {
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.shipping = shipping;
        this.phone = phone;
        this.highestBid = highestBid;
        this.user = user;
        this.subCategory = subCategory;
    }

    public Product(String name, String description, double startPrice, Date startDate, Date endDate, boolean featured, boolean shipping, String phone, double highestBid, User user, Set<Photo> photos) {
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.featured = featured;
        this.shipping = shipping;
        this.phone = phone;
        this.highestBid = highestBid;
        this.user = user;
        this.photos = photos;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    @NotBlank(message = "Name cannot be blank")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Description cannot be blank")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(double startPrice) {
        this.startPrice = startPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getShipping() {
        return shipping;
    }

    public void setShipping(Boolean shipping) {
        this.shipping = shipping;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }


    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public int getNumberOfBids() {
        return numberOfBids;
    }

    public void setNumberOfBids(int numberOfBids) {
        this.numberOfBids = numberOfBids;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public SubCategory getSubcategory() {
        return subCategory;
    }

    public void setSubcategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }


    @Override
    public void update(Product obj) {

    }

    @Override
    public Product duplicate(Product obj) {
        return null;
    }
}
