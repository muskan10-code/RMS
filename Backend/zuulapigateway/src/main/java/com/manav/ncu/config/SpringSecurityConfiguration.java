package com.manav.ncu.config;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	UserDetailsService userDetailsService;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
		/*http.authorizeRequests().antMatchers("/payment").authenticated()
		.antMatchers("/find").permitAll().and().formLogin().and().httpBasic();*/
	    System.out.println("inside configure");
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and().cors().configurationSource(new CorsConfigurationSource() {
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				// TODO Auto-generated method stub
				System.out.println("inside cors");
				CorsConfiguration corsConfig=new CorsConfiguration();
				corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				corsConfig.setAllowedMethods(Collections.singletonList("*"));
				corsConfig.setAllowCredentials(true);
				corsConfig.setAllowedHeaders(Collections.singletonList("*"));
				corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
				corsConfig.setMaxAge(3600L);
				return corsConfig;
			}
		}).and().csrf().disable()
		.addFilterBefore(new VerifyTokenFilter(),BasicAuthenticationFilter.class)
		.addFilterAfter(new JWTTokenGeneratorFilter(),BasicAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/loginuser").hasAnyAuthority("hardware","manager","software","enduser")
		.antMatchers("/payment").hasAuthority("software")
		.antMatchers("/find").hasAuthority("hardware")
		.antMatchers("/contactme").hasAuthority("software")
		.antMatchers("/user-service/findemployee").hasAnyAuthority("manager")
		.antMatchers("/taskstatus-service/getalltask").hasAnyAuthority("manager")
		.antMatchers("/taskstatus-service/getpendingcount").hasAnyAuthority("manager")
		.antMatchers("/taskstatus-service/getfinishcount").hasAuthority("manager")
		.antMatchers("/taskstatus-service/getassignTask**").hasAnyAuthority("hardware","software","network")
		.antMatchers("/task-service/addtask").hasAuthority("enduser")
		.antMatchers("/task-service/updatestartedstatus**").hasAnyAuthority("hardware","software","network")
		.antMatchers("/task-service/updatefinishstatus**").hasAnyAuthority("hardware","software","network")
		.antMatchers("/task-service/usertask**").hasAuthority("enduser")
		.antMatchers("/incentive-service/userreward**").hasAnyAuthority("harware","software","network")
		.antMatchers("/incentive-service/assignuserreward**").hasAuthority("enduser")
		.antMatchers("/incentive-service/assignreward**").permitAll()
		.antMatchers("/user-service/register").permitAll()
		.anyRequest().authenticated().and().httpBasic();
	}
	 // software eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJNYW5hdiBhbmQgRnJpZW5kcyIsInN1YiI6IkpXVCBUb2tlbiIsInVzZXJuYW1lIjoibW9oaXQxMjMiLCJhdXRob3JpdGllcyI6ImhhcmR3YXJlIiwiaWF0IjoxNjIzNDM0MTQ5LCJleHAiOjE2MjM1MjA1NDl9.vsTL43QKUPBbN1KJhSMhlcq31YHzzZBIf_4kG-seT3A
	 // hardware hcmR3YXJlIiwiaWF0IjoxNjIzNDM0NDk3LCJleHAiOjE2MjMeyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJNYW5hdiBhbmQgRnJpZW5kcyIsInN1YiI6IkpXVCBUb2tlbiIsInVzZXJuYW1lIjoibW9oaXQxMjMiLCJhdXRob3JpdGllcyI6Imh1MjA4OTd9.8F_19opE476xHE6F8hDBdy76KhP4uPvg2NPCTQIW5R4
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}