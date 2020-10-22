package com.atlantbh.auction.model.dto;


import javax.validation.constraints.NotBlank;

public class CategoryDto {

    private String name;

    public CategoryDto() {

    }

    public CategoryDto(String name) {
        this.name = name;
    }

    @NotBlank(message = "Categry name cannot be empty.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
