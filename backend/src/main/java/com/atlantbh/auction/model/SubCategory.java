package com.atlantbh.auction.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "subcategory")
public class SubCategory extends BaseModel<SubCategory, Long> {

    @Column(name = "name")
    private String name;
    @Column(name = "photo_url")
    private String photoUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
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

    }

    @Override
    public SubCategory duplicate(SubCategory obj) {
        return null;
    }
}
