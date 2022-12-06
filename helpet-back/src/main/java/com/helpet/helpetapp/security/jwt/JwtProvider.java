package com.helpet.helpetapp.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.helpet.helpetapp.security.entity.UsuarioMain;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;


@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    
    public String generateToken(Authentication authentication){
        UsuarioMain usuarioMain = (UsuarioMain) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioMain.getUsername())
                             .setIssuedAt(new Date())
                             .setExpiration(new Date(new Date().getTime()+expiration*1000))
                             .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                             .compact();
                                      
    }
    
    public String getNombreUsuarioFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(token).getBody().getSubject();
    }
    
    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(secret.getBytes()).build().parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("Token mal formado.");
        } catch (UnsupportedJwtException e) {
            logger.error("Token no soportado.");
        } catch (ExpiredJwtException e) {
            logger.error("Token expirado.");
        } catch (IllegalArgumentException e) {
            logger.error("Token vacio.");
        }
        
        return false;
    }
}
