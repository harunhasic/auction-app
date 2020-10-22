package com.atlantbh.auction.model.dto;

import com.atlantbh.auction.model.Photo;
import com.atlantbh.auction.model.SubCategory;
import com.atlantbh.auction.model.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class ProductDto {

    private Long id;
    private String name;
    private String description;
    private Double startPrice;
    private SubCategory subCategory;
    private Date startDate;
    private Date endDate;
    private Set<Photo> photoUrl;
    private User user;
    private Photo photo;

    public ProductDto(Long id, String name, String description, Double startPrice, SubCategory subCategory, Date startDate, Date endDate, Set<Photo> photoUrl, User user) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.subCategory = subCategory;
        this.startDate = startDate;
        this.endDate = endDate;
        this.photoUrl = photoUrl;
        this.user = user;
    }

    @NotNull
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotBlank(message = "Name cannot be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    @NotNull
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }


    @NotNull
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Photo> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(Set<Photo> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }
}
