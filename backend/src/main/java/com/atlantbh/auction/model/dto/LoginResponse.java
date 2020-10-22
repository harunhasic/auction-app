package com.atlantbh.auction.model.dto;

/**
 * Class that represents the response given after user logs in.
 *
 * @author Harun Hasic
 */
public class LoginResponse {

    private String email;

    public LoginResponse(String email) {
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}