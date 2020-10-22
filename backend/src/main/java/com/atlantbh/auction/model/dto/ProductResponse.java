package com.atlantbh.auction.model.dto;

import com.atlantbh.auction.model.Photo;

import java.time.LocalDateTime;
import java.util.List;

public class ProductResponse {
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private Double startPrice;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<Photo> photos;

    public ProductResponse(Long id, Long userId, String name, String description, Double startPrice, LocalDateTime startDate, LocalDateTime endDate, List<Photo> photos) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.startPrice = startPrice;
        this.startDate = startDate;
        this.endDate = endDate;
        this.photos = photos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    public Double getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }
}
