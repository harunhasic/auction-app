package com.atlantbh.auction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "photo")
public class Photo extends BaseModel<Photo, Long> {

    @Column(name = "photo_url")
    private String photoUrl;
    @Column(nullable = false)
    private Boolean featured = false;

    public Photo() {

    }

    public Photo(String photoUrl, Boolean featured) {
        this.photoUrl = photoUrl;
        this.featured = featured;
    }


    @NotBlank(message = "Photo url cannot be empty")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    @Override
    public void update(Photo obj) {

    }

    @Override
    public Photo duplicate(Photo obj) {
        return null;
    }
}
