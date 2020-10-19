package com.atlantbh.auction.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ratings")
public class Rating extends BaseModel<Rating, Long> {

    @Min(1)
    @Max(5)
    private Integer rating;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", updatable = false)
    private User user;

    public Rating() {
    }

    public Rating(Integer rating, String comment, User user) {
        this.rating = rating;
        this.comment = comment;
        this.user = user;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    @Override
    public void update(Rating obj) {

    }

    @Override
    public Rating duplicate(Rating obj) {
        return null;
    }
}
