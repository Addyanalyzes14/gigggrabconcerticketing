package com.giggrabconcert.filter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.giggrabconcert.util.CookieUtil;
import com.giggrabconcert.util.SessionUtil;

@WebFilter(asyncSupported = true, urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	private static final String INDEXCONTROLLER = "/indexController";
	private static final String SIGNUPCONTROLLER= "/signupController";
	private static final String HOMEPAGECONTROLLER ="/homepageController";
	private static final String ROOT = "/";
	private static final String DASHBOARDCONTROLLER = "/dashboardController";
	private static final String USERCONTROLLER = "/usercontroller";
	private static final String UPDATECONTROLLER = "//updatecontroller";
	private static final String ADMINPROFILECONTROLLER = "/adminprofileController";
	private static final String TICKET_LIST = "/ticketlist";
	private static final String PORTFOLIO = "/portfolio";    


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic, if required
	}

@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
	
		// Allow access to resources
		if (uri.endsWith(".png") || uri.endsWith(".jpg") || uri.endsWith(".css")) {
		chain.doFilter(request, response);
			return;
		}
		
		boolean isLoggedIn = SessionUtil.getAttribute(req, "username") != null;
		String userRole = CookieUtil.getCookie(req, "role") != null ? CookieUtil.getCookie(req, "role").getValue()
				: null;

		if ("admin".equals(userRole)) {
	
		if (uri.endsWith(INDEXCONTROLLER) || uri.endsWith(SIGNUPCONTROLLER)) {
			res.sendRedirect(req.getContextPath() + DASHBOARDCONTROLLER);
			} else if (uri.endsWith(DASHBOARDCONTROLLER) || uri.endsWith(USERCONTROLLER) || uri.endsWith(UPDATECONTROLLER)
					|| uri.endsWith(ADMINPROFILECONTROLLER) || uri.endsWith(HOMEPAGECONTROLLER) || uri.endsWith(ROOT)) {
				chain.doFilter(request, response);
		} else if (uri.endsWith(TICKET_LIST))  {
				res.sendRedirect(req.getContextPath() + DASHBOARDCONTROLLER);
			} else {
				res.sendRedirect(req.getContextPath() + DASHBOARDCONTROLLER);                                                                
			}
		} else if ("user".equals(userRole)) {
			// User is logged in
			if (uri.endsWith(INDEXCONTROLLER) || uri.endsWith(SIGNUPCONTROLLER)) {                                                              
			res.sendRedirect(req.getContextPath() + HOMEPAGECONTROLLER);
			} else if (uri.endsWith(HOMEPAGECONTROLLER) || uri.endsWith(ROOT)|| uri.endsWith(PORTFOLIO)
					 || uri.endsWith(TICKET_LIST) ) {
				chain.doFilter(request, response);
		} else if (uri.endsWith(DASHBOARDCONTROLLER) || uri.endsWith(USERCONTROLLER) || uri.endsWith(UPDATECONTROLLER)|| uri.endsWith(ADMINPROFILECONTROLLER)) {
				res.sendRedirect(req.getContextPath() + HOMEPAGECONTROLLER);
		} else {
			res.sendRedirect(req.getContextPath() + HOMEPAGECONTROLLER);
		}
	} else {
			// Not logged in
			if (uri.endsWith(INDEXCONTROLLER) || uri.endsWith(SIGNUPCONTROLLER) || uri.endsWith(HOMEPAGECONTROLLER) || uri.endsWith(ROOT)) {
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(req.getContextPath() + INDEXCONTROLLER);
			}
		}
	}

	@Override
	public void destroy() {
		// Cleanup logic, if required
	}
}
