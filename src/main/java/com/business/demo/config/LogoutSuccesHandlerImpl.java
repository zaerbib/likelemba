package com.business.demo.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.business.demo.util.CustomLogout;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class LogoutSuccesHandlerImpl implements LogoutSuccessHandler {
	
	private ObjectMapper mapper;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter writer = response.getWriter();
		
		mapper.writeValue(writer, new CustomLogout("Deconnexion reussie !"));
	}
}
