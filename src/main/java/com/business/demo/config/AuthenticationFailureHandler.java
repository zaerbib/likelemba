package com.business.demo.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.business.demo.util.CustomErrorType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private ObjectMapper mapper;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		PrintWriter writer = response.getWriter();
		
		if(exception instanceof BadCredentialsException) {
			mapper.writeValue(writer, new CustomErrorType("Login/Mot de passe incorrect"));
		} else {
			mapper.writeValue(writer, exception.getMessage());
		}
		writer.flush();
	}	
}
