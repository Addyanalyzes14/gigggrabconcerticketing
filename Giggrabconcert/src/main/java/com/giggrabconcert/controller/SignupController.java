package com.giggrabconcert.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.giggrabconcert.model.TicketModel;
import com.giggrabconcert.model.UserModel;
import com.giggrabconcert.service.RegisterService;
import com.giggrabconcert.util.PasswordUtil;
import com.giggrabconcert.util.ValidationUtil;

import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/signupController"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterService registerService;

    public void init ()throws ServletException{
    this.registerService = new RegisterService();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String validationMessage = validateRegistrationForm(request);
            if (validationMessage != null) {
                handleError(request, response, validationMessage);
                return;
            }

            UserModel usermodel = extractUserModel(request);
            Boolean isAdded = this.registerService.addUser(usermodel);



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

        if (!ValidationUtil.isAlphanumericStartingWithLetter(username))
            return "Username must start with a letter and contain only letters and numbers.";
        if (!ValidationUtil.isValidEmail(email))
            return "Invalid email format.";
        if (!ValidationUtil.isValidnumber(number))
            return "Phone number must be 10 digits and start with 98.";
        if (!ValidationUtil.isValidPassword(password))
            return "Password must be at least 8 characters long, with 1 uppercase letter, 1 number, and 1 symbol.";

        return null;
    }

    private UserModel extractUserModel(HttpServletRequest request) throws Exception {
        String fullname = request.getParameter("fullname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String password = request.getParameter("password");

        password = PasswordUtil.encrypt(username, password);

        // For now, ticket is optional or dummy
        TicketModel ticket = new TicketModel("Default Event");

        return new UserModel(fullname, email, number, password, username, ticket);
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
        request.setAttribute("number", request.getParameter("number")); // Make sure it's "number" not "phoneNumber"
        request.getRequestDispatcher("/WEB-INF/pages/signup.jsp").forward(request, response);
    }
}
