package com.business.demo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.business.demo.config.AppAuthProvider;
import com.business.demo.config.AuthenticationFailureHandler;
import com.business.demo.config.AuthenticationSuccessHandlerImpl;
import com.business.demo.config.LogoutSuccesHandlerImpl;

public class WebSecurirtyConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationFailureHandler authenticationFailure;
	
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccess;
	
	@Autowired
	private LogoutSuccesHandlerImpl logoutSuccess;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		AppAuthProvider appAuthProvider = new AppAuthProvider();
		auth.authenticationProvider(appAuthProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable();
	        http
	                .authorizeRequests()
	                .antMatchers("*/login").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .formLogin()
	                .loginProcessingUrl("/api/login")
	                .usernameParameter("email")
	                .passwordParameter("password")
	                .permitAll()
	                .and()
	                .logout()
	                .permitAll();
	        http.formLogin().successHandler(authenticationSuccess);
	        http.formLogin().failureHandler(authenticationFailure);
	        http.logout().permitAll().logoutUrl("/api/logout").logoutSuccessHandler(logoutSuccess);
	        http.headers().frameOptions().sameOrigin();
	}
}
