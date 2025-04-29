package com.giggrabconcert.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.MultipartConfig;
import com.giggrabconcert.util.PasswordUtil;
import com.giggrabconcert.util.ValidationUtil;
import com.giggrabconcert.model.TicketModel;
import com.giggrabconcert.model.UserModel;
import com.giggrabconcert.service.RegisterService;
import java.io.IOException;

/**
 * Servlet implementation class SignupController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/signup" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/pages/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Validate and extract student model
			String validationMessage = validateRegistrationForm(request);
			if (validationMessage != null) {
				handleError(request, response, validationMessage);
				return;
			}

			UserModel usermodel = extractUserModel(request);
			Boolean isAdded = RegisterService.adduser(usermodel);

			if (isAdded == null) {
				handleError(request, response, "Our server is under maintenance. Please try again later!");
			} else if (isAdded) {
				handleSuccess(request, response, "Your account is successfully created!", "/WEB-INF/pages/index.jsp");
			} else {
				handleError(request, response, "Could not register your account. Please try again later!");
			}
		} catch (Exception e) {
			handleError(request, response, "An unexpected error occurred. Please try again later!");
			e.printStackTrace(); // Log the exception
		}
	}

	private String validateRegistrationForm(HttpServletRequest request) {
		String fullname = request.getParameter("fullname");
	    String username = request.getParameter("username");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
	

		// Check for null or empty fields first
		if (ValidationUtil.isNullOrEmpty(fullname))
			return "Full name is required.";
		if (ValidationUtil.isNullOrEmpty(username))
			return "Username is required.";
		if (ValidationUtil.isNullOrEmpty(email))
			return "Email is required.";
		if (ValidationUtil.isNullOrEmpty(number))
			return "Phone number is required.";
		if (ValidationUtil.isNullOrEmpty(password))
			return "Password is required.";
		
		// Validate fields
		if (!ValidationUtil.isAlphanumericStartingWithLetter(username))
			return "Username must start with a letter and contain only letters and numbers.";
		if (!ValidationUtil.isValidEmail(email))
			return "Invalid email format.";
		if (!ValidationUtil.isValidnumber(number))
			return "Phone number must be 10 digits and start with 98.";
		if (!ValidationUtil.isValidPassword(password))
			return "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";

	private UserModel extractUserModel(HttpServletRequest request) throws Exception {
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");

		// Assuming password validation is already done in validateRegistrationForm
		password = PasswordUtil.encrypt(username, password);

		TicketModel ticketModel = new TicketModel(ticket);
		return new TicketModel();

	}

	private void handleSuccess(HttpServletRequest request, HttpServletResponse response, String message,
			String redirectPage) throws ServletException, IOException {
		request.setAttribute("success", message);
		request.getRequestDispatcher(redirectPage).forward(request, response);
	}

	private void handleError(HttpServletRequest request, HttpServletResponse response, String message)
			throws ServletException, IOException {
		request.setAttribute("error", message);
		request.setAttribute("fullname", request.getParameter("fullname"));
		request.setAttribute("username", request.getParameter("username"));
		request.setAttribute("email", request.getParameter("email"));
		request.setAttribute("number", request.getParameter("phoneNumber"));
		request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
	}
}
