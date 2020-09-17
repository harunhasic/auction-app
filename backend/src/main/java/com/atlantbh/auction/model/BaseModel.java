package com.atlantbh.auction.model;

import javax.persistence.*;

/**
 * BaseModel is the main generic class used for deriving and making entity classes
 * @author Harun Hasic
 */
@MappedSuperclass
public abstract class BaseModel<M,I> {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     protected I id;


    public I getId() {
        return id;
    }

    public void setId(I id) {
        this.id = id;
    }

    public abstract void update();
    public abstract M duplicate();


}
