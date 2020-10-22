package com.atlantbh.auction.model.dto;

import javax.validation.constraints.NotBlank;

public class SubCategoryDto {

    private String name;
    private Long categoryId;

    public SubCategoryDto() {

    }

    public SubCategoryDto(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    @NotBlank(message = "Subcategory name cannot be empty")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotBlank(message = "Category id  cannot be empty")
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
