package com.atlantbh.auction.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Represents a base model we'll be extending by all other models of this application.
 * Assigns an unique ID of specified type to each model entry that extends this class.
 * ID type is specified in the extended class, in the <> braces.
 * @author Harun Hasic
 */
@MappedSuperclass
public abstract class BaseModel<M, I> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected I id;

    @NotNull(message = "Table ID cannot be null.")
    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public abstract void update(M obj);

    public abstract M duplicate(M obj);
}