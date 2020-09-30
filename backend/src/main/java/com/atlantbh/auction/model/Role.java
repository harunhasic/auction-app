package com.atlantbh.auction.model;


import org.springframework.security.core.GrantedAuthority;

/**
 * Role enum that marks roles that can be assigned to the users..
 * TODO - Implementation & security not finished.
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
