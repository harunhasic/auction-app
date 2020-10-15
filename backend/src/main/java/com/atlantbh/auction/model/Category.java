package com.atlantbh.auction.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category extends BaseModel<Category, Long> {

    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Category obj) {

    }

    @Override
    public Category duplicate(Category obj) {
        return null;
    }
}
