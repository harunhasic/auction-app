package com.atlantbh.auction.model;


import org.apache.commons.lang3.NotImplementedException;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category extends BaseModel<Category, Long> {

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "category")
    private Set<SubCategory> subcategories;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Set<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Category model) {
        name = model.name;
    }

    @Override
    public Category duplicate(Category obj) throws NotImplementedException {
        throw new NotImplementedException("The duplicate method is not implemented for the Category model");
    }
}
