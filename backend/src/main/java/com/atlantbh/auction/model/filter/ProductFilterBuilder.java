package com.atlantbh.auction.model.filter;

import com.atlantbh.auction.model.enums.ProductSortKeys;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

/**
 * Product filter builder used for the filtering of the products.
 *
 * @author Harun Hasic
 */
public class ProductFilterBuilder extends BaseFilterBuilder<ProductSortKeys, ProductFilterBuilder> {

    private String name;
    private Double startPrice;
    private String size;
    private String color;
    private String subCategory;
    private String category;
    private Double maxPrice;
    private Double minPrice;

    @Override
    protected Criteria addConditions(Criteria rootCriteria, boolean isCountCriteria) {
        rootCriteria.createAlias("subCategory", "sc");
        rootCriteria.createAlias("sc.category", "cat");
        if (!StringUtils.isEmpty(name)) {
            rootCriteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
        }
        if (maxPrice != null && minPrice != null) {
            rootCriteria.add(Restrictions.between("startPrice", minPrice, maxPrice));
        }
        if (!StringUtils.isEmpty(size)) {
            rootCriteria.add(Restrictions.eq("size", size));
        }
        if (!StringUtils.isEmpty(color)) {
            rootCriteria.add(Restrictions.ilike("color", color, MatchMode.ANYWHERE));
        }
        if (!StringUtils.isEmpty(subCategory)) {
            rootCriteria.add(Restrictions.ilike("sc.name", subCategory));
        }
        if (!StringUtils.isEmpty(category)) {
            rootCriteria.add(Restrictions.ilike("cat.name", category));
        }
        return rootCriteria;
    }

    public String getName() {
        return name;
    }

    public ProductFilterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Double getStartPrice() {
        return startPrice;
    }

    public ProductFilterBuilder setStartPrice(Double startPrice) {
        this.startPrice = startPrice;
        return this;
    }

    public String getSize() {
        return size;
    }

    public ProductFilterBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    public ProductFilterBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public ProductFilterBuilder setSubCategory(String subCategory) {
        this.subCategory = subCategory;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductFilterBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public ProductFilterBuilder setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    public ProductFilterBuilder setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
        return this;
    }


}
