package com.giggrabconcert.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(asyncSupported = true, urlPatterns = { "/paymentController" })
public class PaymentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public PaymentController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PaymentController doGet invoked");
        request.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("PaymentController doPost invoked");
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (firstName == null || firstName.trim().isEmpty() || email == null || email.trim().isEmpty()) {
            request.setAttribute("error", "First name and email are required.");
            request.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(request, response);
            return;
        }

        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        request.setAttribute("email", email);
        request.setAttribute("phone", phone);
        request.setAttribute("success", "Payment details submitted successfully!");

        request.getRequestDispatcher("/WEB-INF/pages/payment.jsp").forward(request, response);
    }
}