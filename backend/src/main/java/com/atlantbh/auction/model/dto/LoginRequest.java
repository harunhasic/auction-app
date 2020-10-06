package com.atlantbh.auction.model.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Email cannot be empty")
    private String email;
    @NotBlank(message = "Password cannot be empty")

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}