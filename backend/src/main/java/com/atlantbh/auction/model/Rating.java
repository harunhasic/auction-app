package com.atlantbh.auction.model;

import org.apache.commons.lang3.NotImplementedException;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "ratings")
public class Rating extends BaseModel<Rating, Long> {

    @Column(name = "rating")
    @Min(value = 1, message = "The minimum rating is 1")
    @Max(value = 5, message = "The maximum rating is 5")
    private int rating;

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void update(Rating model) {
        rating = model.rating;
        comment = model.comment;
    }

    @Override
    public Rating duplicate(Rating obj) throws NotImplementedException {
        throw new NotImplementedException("The duplicate method is not implemented for the Rating model");
    }
}
