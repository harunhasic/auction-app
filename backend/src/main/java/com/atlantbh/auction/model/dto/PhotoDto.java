package com.atlantbh.auction.model.dto;

import javax.validation.constraints.NotBlank;

public class PhotoDto {

    private String photoUrl;

    public PhotoDto() {

    }

    public PhotoDto(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @NotBlank(message = "Photo url cannot be empty")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}

