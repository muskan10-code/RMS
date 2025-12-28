package com.manav.ncu.config;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.header.Header;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null) {
		SecretKey key=Keys.hmacShaKeyFor(MySecurityConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
		System.out.println("Inside auth");
		String jwtToken=Jwts.builder().setIssuer("Manav and Friends").setSubject("JWT Token")
		.claim("username", auth.getName())
		.claim("authorities",getAuthorities(auth.getAuthorities()))
		.setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+24*60*60*1000))
		.signWith(key).compact();
		System.out.println(jwtToken);
		//HttpHeaders header=new HttpHeaders();
		//header.set(MySecurityConstant.JWT_HEADER,jwtToken);
		//header.set("role", getAuthorities(auth.getAuthorities()));
		response.setHeader(MySecurityConstant.JWT_HEADER,jwtToken);
		response.setHeader("role",getAuthorities(auth.getAuthorities()));;
		/*OutputStream out=response.getOutputStream();
		Map<String,String> map=new HashMap<>();
		map.put("role", getAuthorities(auth.getAuthorities()));
		out.write(map);*/
		}
		filterChain.doFilter(request, response);
	}
String getAuthorities(Collection<? extends GrantedAuthority> authCollection) {
	Set<String> set=new HashSet<>();
	for(GrantedAuthority ga:authCollection) {
		String auth=ga.getAuthority();
		set.add(auth);
	}
	return String.join(",", set);
}
}