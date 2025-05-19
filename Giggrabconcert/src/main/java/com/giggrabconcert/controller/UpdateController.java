package com.giggrabconcert.controller;

import java.io.IOException;

import com.giggrabconcert.model.UserModel;
import com.giggrabconcert.model.TicketModel;
import com.giggrabconcert.service.UpdateService;
import com.giggrabconcert.util.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/updatecontroller" })
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Service for updating user information
    private UpdateService updateService;

    /**
     * Default constructor initializes the UpdateService instance.
     */
    public UpdateController() {
        this.updateService = new UpdateService();
    }

    /**
     * Handles HTTP GET requests by retrieving student information from the session 
     * and forwarding the request to the update JSP page.
     * 
     * @param req The HttpServletRequest object containing the request data.
     * @param resp The HttpServletResponse object used to return the response.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an input or output error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve and set user information from the session if available
        if (request.getSession().getAttribute("user") != null) {
            UserModel user = (UserModel) SessionUtil.getAttribute(request, "user");
            SessionUtil.removeAttribute(request, "user");
            request.setAttribute("user", user);
        }

        // Forward to the update JSP page
        request.getRequestDispatcher("/WEB-INF/pages/admin/update.jsp").forward(request, response);
    }

    /**
     * Handles HTTP POST requests for updating student information.
     * Retrieves student data from the request parameters, updates the student record 
     * in the database using UpdateService, and redirects to the dashboard or 
     * handles update failure.
     * 
     * @param req The HttpServletRequest object containing the request data.
     * @param resp The HttpServletResponse object used to return the response.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an input or output error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve student data from request parameters
    	String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String eventName = request.getParameter("event"); 

		// Create a TicketModel object
					TicketModel ticket = new TicketModel();
					ticket.setEventName(request.getParameter(eventName));

					// Create a UserModel object
				     UserModel user = new UserModel(fullname,email,number,password,username,null);
				     
        // Attempt to update user information in the database
        Boolean result = updateService.updateUserInfo(user);
        if (result != null && result) {
            response.sendRedirect(request.getContextPath() + "/usercontroller"); // Redirect to dashboard on success
        } else {
            request.getSession().setAttribute("user", user);
            handleUpdateFailure(request, response, result); // Handle failure
        }
    }

    /**
     * Handles update failures by setting an error message and forwarding the request 
     * back to the update page.
     * 
     * @param req The HttpServletRequest object containing the request data.
     * @param resp The HttpServletResponse object used to return the response.
     * @param loginStatus Indicates the result of the update operation.
     * @throws ServletException If an error occurs during request processing.
     * @throws IOException If an input or output error occurs.
     */
    private void handleUpdateFailure(HttpServletRequest request, HttpServletResponse response, Boolean loginStatus)
            throws ServletException, IOException {
        // Determine error message based on update result
        String errorMessage;
        if (loginStatus == null) {
            errorMessage = "Our server is under maintenance. Please try again later!";
        } else {
            errorMessage = "Update Failed. Please try again!";
        }
        request.setAttribute("error", errorMessage);
        request.getRequestDispatcher(request.getContextPath() + "/update").forward(request, response);
    }
}