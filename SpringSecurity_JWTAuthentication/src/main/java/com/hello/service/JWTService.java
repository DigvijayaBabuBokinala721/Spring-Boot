package com.hello.service;

import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	private String key = "dsklfalaskdfhskljfhgiryijfdshjfuubfergurebgugbregberugbghgdoevsmvzbvm85934750293sjkfhskhsakj84573489j";
	private SecretKey secretKey;
	
	public JWTService() {
		secretKey = Keys.hmacShaKeyFor(key.getBytes());
	}
	
	
	public String generateToken(String username) {
		return Jwts.builder()
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+1000*60*30)) 
				.signWith(secretKey)
				.compact();
	}
	
	public String extractUsername(String token) {
		return extractClaims(token,Claims::getSubject);
	}
	
	public<T> T extractClaims(String token,Function<Claims,T> function) {
		return function.apply(extractAllClaims(token));
	}
	
	public Claims extractAllClaims(String token) {
		
		try {
			return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
		}catch (Exception e) {
//			System.out.println("expired");
			throw new RuntimeException("token expired");
		}
//		return null;
	}
	
	public boolean isValid(String token,UserDetails details) {
		return extractUsername(token).equals(details.getUsername()) && !isExpired(token);
	}


	private boolean isExpired(String token) {
//		System.out.println(extractClaims(token, Claims::getExpiration).before(new Date()));
		return extractClaims(token, Claims::getExpiration).before(new Date());
	}
	
	
}
