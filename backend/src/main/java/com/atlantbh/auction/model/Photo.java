package com.atlantbh.auction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "photo")
public class Photo extends BaseModel<Photo, Long> {

    private String photoUrl;


    @Column(nullable = false)
    private boolean featured = false;

    public Photo() {

    }

    public Photo(String photoUrl, boolean featured) {
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
