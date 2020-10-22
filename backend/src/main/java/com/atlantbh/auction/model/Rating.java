package com.atlantbh.auction.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ratings")
public class Rating extends BaseModel<Rating, Long> {

    @Column(name = "rating")
    @Min(1)
    @Max(5)
    private Integer rating;
    @Column(name = "comment")
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
