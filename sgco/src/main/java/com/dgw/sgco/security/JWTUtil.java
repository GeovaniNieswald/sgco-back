package com.dgw.sgco.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWTUtil
 */
@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * Método para gerar o token
     * 
     * @param email - String
     * @return String (token)
     */
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    /**
     * Método para verificar se o token é válido
     * 
     * @param token String
     * @return Claims
     */
    public boolean tokenValido(String token) {
        Claims claims = getClaims(token);

        if (claims != null) {
            String username = claims.getSubject();
            Date dateExpiration = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());

            if (username != null && expiration != null && now.before(dateExpiration)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Método para retonar o email do token
     * 
     * @param token
     * @return
     */
    public String getUsername(String token) {
        Claims claims = getClaims(token);

        if (claims != null) {
            return claims.getSubject();
        }

        return null;
    }

    /**
     * Método para retornar as Claims do token
     * 
     * @param token String
     * @return Claims
     */
    private Claims getClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        } catch (Exception ex) {
            return null;
        }
    }

}
