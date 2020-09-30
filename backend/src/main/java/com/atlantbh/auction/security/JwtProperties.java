package com.atlantbh.auction.security;

public class JwtProperties {

    public static final String SIGN_UP_URLS = "/api/users/**";
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX = "";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 900_000; //90 seconds
}