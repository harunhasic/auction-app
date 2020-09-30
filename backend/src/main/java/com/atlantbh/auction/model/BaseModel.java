package com.atlantbh.auction.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * main generic class used for deriving and making entity classes..
 *
 * @author Harun Hasic
 */
@MappedSuperclass
public abstract class BaseModel<M, I> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected I id;

    @NotNull
    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public abstract void update(M obj);

    public abstract M duplicate(M obj);
}
