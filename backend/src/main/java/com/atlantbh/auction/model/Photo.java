package com.atlantbh.auction.model;

import org.apache.commons.lang3.NotImplementedException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "photo")
public class Photo extends BaseModel<Photo, Long> {

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(nullable = false, name = "featured")
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

    public boolean getFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    @Override
    public void update(Photo model) {
        photoUrl = model.photoUrl;
        featured = model.featured;
    }

    @Override
    public Photo duplicate(Photo obj) throws NotImplementedException {
        throw new NotImplementedException("The duplicate method is not implemented for Photo model");
    }
}
