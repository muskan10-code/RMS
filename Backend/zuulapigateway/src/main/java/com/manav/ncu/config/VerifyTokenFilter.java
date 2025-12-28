package com.manav.ncu.config;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class VerifyTokenFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jwtToken=request.getHeader(MySecurityConstant.JWT_HEADER);
		if(jwtToken!=null) {
		SecretKey key=	Keys.hmacShaKeyFor(MySecurityConstant.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
		Claims claim=Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
		String username=claim.get("username").toString();
		String auth=claim.get("authorities").toString();
		Authentication authentication=new UsernamePasswordAuthenticationToken(username,null,AuthorityUtils.commaSeparatedStringToAuthorityList(auth));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		filterChain.doFilter(request, response);
	}
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
		return request.getServletPath().equals("/payment")||request.getServletPath().equals("/loginuser")||request.getServletPath().equals("/user-service/register");
	}
}
