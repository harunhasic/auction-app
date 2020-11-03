package com.atlantbh.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.NotImplementedException;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "subcategory")
public class SubCategory extends BaseModel<SubCategory, Long> {

    @Column(name = "name")
    private String name;

    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Category category;

    public SubCategory() {

    }

    public SubCategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    @NotBlank(message = "Subcategory name cannot be empty.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public void update(SubCategory obj) {
        name = obj.name;
        photoUrl = obj.photoUrl;
    }

    @Override
    public SubCategory duplicate(SubCategory obj) throws NotImplementedException {
        throw new NotImplementedException("The duplicate method is not implemented for SubCategory model");
    }
}
