package com.atlantbh.auction.model.enums;


import org.springframework.security.core.GrantedAuthority;

/**
 * Enum we'll be using for adding roles to users.
 * ADMIN- A user that has the most authority when it comes to the application. Can manipulate other users, products and so on.
 * USER - Basic user that has the ability to check out products, buy and sell them.
 *
 * @author Harun Hasic
 */

public enum Role implements GrantedAuthority {
    ADMIN,
    USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
