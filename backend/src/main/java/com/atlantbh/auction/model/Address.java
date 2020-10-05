package com.atlantbh.auction.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Model that is used as an address property of the users of the application.
 *
 * @author Harun Hasic
 */
@Entity
@Table(name = "address")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address extends BaseModel<Address, Long> {

    private String street;
    private String city;
    private String zipCode;
    private String country;

    public Address() {
    }

    public Address(String street, String city, String state, String country, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public void update(Address obj) {

    }

    @Override
    public Address duplicate(Address obj) {
        return null;
    }
}
