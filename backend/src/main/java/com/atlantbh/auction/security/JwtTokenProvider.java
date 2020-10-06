package com.atlantbh.auction.security;

import com.atlantbh.auction.model.User;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Component that generates the tokens used for user authentication.
 *
 * @author Harun Hasic
 */
@Component
public class JwtTokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    private String id = "id";
    private String username = "username";
    private String firstName = "firstName";

    public static final long EXPIRATION_TIME = 900_000;

    //Generate the token
    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());

        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        String userId = Long.toString(user.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put(id, (Long.toString(user.getId())));
        claims.put(username, user.getUsername());
        claims.put(firstName, user.getFirstName());

        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            LOGGER.error("Invalid JWT Signature", e);
        } catch (MalformedJwtException e) {
            LOGGER.error("Invalid JWT Token", e);
        } catch (ExpiredJwtException e) {
            LOGGER.error("Expired JWT Token", e);
        } catch (UnsupportedJwtException e) {
            LOGGER.error("Unsupported JWT Token", e);
        } catch (IllegalArgumentException e) {
            LOGGER.error("JWT Claims String is empty", e);
        }
        return false;
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String id = (String) claims.get("id");
        return Long.parseLong(id);
    }
}