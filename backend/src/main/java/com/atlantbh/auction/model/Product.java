package com.atlantbh.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
                        @FieldResult(name = "shipping", column = "shipping"),
                        @FieldResult(name = "startPrice", column = "start_price"),
                        @FieldResult(name = "featured", column = "featured")
                }))
public class Product extends BaseModel<Product, Long> {

    @Column(name = "name")
    private String name;

    @Column(length = 4000, columnDefinition = "text")
    @Size(min = 20, max = 4000)
    private String description;

    @Column(name = "start_price")
    @Min(value = 0)
    private double startPrice;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(nullable = false, name = "shipping")
    private boolean shipping = false;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Photo> photos;

    @Column(name = "featured")
    private boolean featured = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id")
    private Set<Rating> rating;

    public Product() {

    }

    public Product(
            String name,
            String description,
            Double startPrice,
            Date startDate,
            Date endDate,
            boolean shipping,
            User user,
            SubCategory subCategory
    ) {
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.shipping = shipping;
        this.user = user;
        this.subCategory = subCategory;
    }

    public Product(
            String name,
            String description,
            double startPrice,
            Date startDate,
            Date endDate,
            boolean featured,
            boolean shipping,
            User user,
            Set<Photo> photos
    ) {
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.featured = featured;
        this.shipping = shipping;
        this.user = user;
        this.photos = photos;
    }

    public Set<Rating> getRating() {
        return rating;
    }

    public void setRating(Set<Rating> rating) {
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
        if (startDate != null) {
            return new Date(startDate.getTime());
        }
        return null;
    }

    public void setStartDate(Date startDate) {
        if (startDate != null) {
            this.startDate = new Date(startDate.getTime());
        } else {
            this.startDate = null;
        }
    }

    public Date getEndDate() {
        if (endDate != null) {
            return new Date(endDate.getTime());
        }
        return null;
    }

    public void setEndDate(Date endDate) {
        if (endDate != null) {
            this.endDate = new Date(endDate.getTime());
        } else {
            this.endDate = null;
        }
    }

    public boolean getShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public Set<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

    public boolean getFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
    public void update(Product model) {
        name = model.name;
        description = model.description;
        photos = model.photos;
        subCategory = model.subCategory;
        shipping = model.shipping;
        featured = model.featured;
        startDate = model.startDate;
        endDate = model.endDate;
        startPrice = model.startPrice;
        user = model.user;
        rating = model.rating;
    }

    @Override
    public Product duplicate(Product model) {
        Product theDuplicate = new Product();
        theDuplicate.name = model.name;
        theDuplicate.description = model.name;
        theDuplicate.startPrice = model.startPrice;
        theDuplicate.photos = model.photos;
        theDuplicate.startDate = model.startDate;
        theDuplicate.endDate = model.endDate;
        return theDuplicate;
    }
}
