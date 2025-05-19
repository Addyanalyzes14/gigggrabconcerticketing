package com.giggrabconcert.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.giggrabconcert.model.UserModel;
import com.giggrabconcert.model.TicketModel;
import com.giggrabconcert.service.DashboardService;
import com.giggrabconcert.util.ValidationUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/usercontroller" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Instance of DashboardService for handling business logic
		private DashboardService dashboardService;

		/**
		 * Default constructor initializes the DashboardService instance.
		 */
		public UserController() {
			this.dashboardService = new DashboardService();
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Retrieve all student information from the DashboardService
			request.setAttribute("userList", dashboardService.getAllUsersInfo());

			
			request.setAttribute("total", dashboardService.getTotalUsers());
			request.setAttribute("arijitsinghconert", dashboardService.getArijitSinghConcert());
			request.setAttribute("shreyaghosalconcert", dashboardService.getShreyaGhosalConcert());
		
			// Forward the request to the students JSP for rendering
			request.getRequestDispatcher("/WEB-INF/pages/admin/students.jsp").forward(request, response);
		}

		/**
		 * Handles HTTP POST requests for various actions such as update, delete, or
		 * redirecting to the update form. Processes the request parameters based on the
		 * specified action.
		 * 
		 * @param request  The HttpServletRequest object containing the request data.
		 * @param response The HttpServletResponse object used to return the response.
		 * @throws ServletException If an error occurs during request processing.
		 * @throws IOException      If an input or output error occurs.
		 */
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String action = request.getParameter("action");
			int userId = Integer.parseInt(request.getParameter("userId"));

			switch (action) {
			case "updateForm":
				handleUpdateForm(request, response, userId);
				break;

			case "update":
				handleUpdate(request, response, userId);
				break;

			case "delete":
				handleDelete(request, response, userId);
				break;

			default:
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Unknown action: " + action);
			}
		}

		/**
		 * Handles the update form action by setting student data in the session and
		 * redirecting to the update page.
		 * 
		 * @param request   The HttpServletRequest object containing the request data.
		 * @param response  The HttpServletResponse object used to return the response.
		 * @param studentId The ID of the student to be updated.
		 * @throws IOException If an input or output error occurs.
		 */
		private void handleUpdateForm(HttpServletRequest request, HttpServletResponse response, int userId)
				throws ServletException, IOException {
			// Retrieve the student information from the service
		    UserModel user = dashboardService.getSpecificUserInfo(userId);

			if (user != null) {
				// Store the user object in the session
				request.getSession().setAttribute("user", user);

				// Redirect to the update URL
				response.sendRedirect(request.getContextPath() + "/userUpdate");
			} else {
				// Handle case where student info is not found
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found with ID: " + userId);
			}
		}

		/**
		 * Handles the update action by processing student data and updating it through
		 * the DashboardService. Redirects to the dashboard page upon completion.
		 * 
		 * @param request   The HttpServletRequest object containing the request data.
		 * @param response  The HttpServletResponse object used to return the response.
		 * @param userId The ID of the user to be updated.
		 * @throws ServletException If an error occurs during request processing.
		 * @throws IOException      If an input or output error occurs.
		 */
		private void handleUpdate(HttpServletRequest request, HttpServletResponse response, int userId)
				throws ServletException, IOException {
			// Validate form parameters
			String validationMessage = validateUpdateForm(request);
			if (validationMessage != null) {
				request.setAttribute("error", validationMessage);
				doGet(request, response); // Reload the page with the error message
				return;
			}

			// Retrieve form parameters
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String number = request.getParameter("number");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			String eventName = request.getParameter("event");
		

			// Create a TicketModel object
			TicketModel ticket = new TicketModel();
			ticket.setEventName(ticketName);

			// Create a UserModel object
		     UserModel user = new UserModel(fullname,email,number,password,username,null,ticket);


			// Update the student using DashboardService
			boolean success = dashboardService.updateUser(user);

			// Handle the result of the update operation
			if (success) {
				request.setAttribute("success", "User information updated successfully.");
			} else {
				request.setAttribute("error", "Failed to update user information.");
			}

			// Forward to the dashboard to reflect changes
			doGet(request, response);
		}

		/**
		 * Validates the form fields for the update operation.
		 * 
		 * @param request The HttpServletRequest object containing the request data.
		 * @return A validation error message, or null if all validations pass.
		 */
		private String validateUpdateForm(HttpServletRequest request) {
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");
			String number = request.getParameter("number");
			String password = request.getParameter("password");
			String username = request.getParameter("username");
			String eventName = request.getParameter("event");
		
			// Check for null or empty fields first
			if (ValidationUtil.isNullOrEmpty(fullname))
				return "Full name is required.";
			if (ValidationUtil.isNullOrEmpty(email))
				return "Email is required.";
			if (ValidationUtil.isNullOrEmpty(number))
				return "Phone number is required.";
			if (ValidationUtil.isNullOrEmpty(password))
				return "Password is required.";
			if (ValidationUtil.isNullOrEmpty(username))
				return "Full name is required.";
			if (ValidationUtil.isNullOrEmpty(eventName))
				return "Eventname is required.";


			// Validate fields
			if (!ValidationUtil.isAlphanumericStartingWithLetter(username))
				return "Username must start with a letter and contain only letters and numbers.";
			if (!ValidationUtil.isValidEmail(email))
				return "Invalid email format.";
			if (!ValidationUtil.isValidnumber(number))
				return "Phone number must be 10 digits and start with 98.";

			

			// Assuming image validation is handled elsewhere
			// return null if all validations pass
			return null;
		}

		/**
		 * Handles the delete action by removing a student from the database and
		 * forwarding to the dashboard page.
		 * 
		 * @param request   The HttpServletRequest object containing the request data.
		 * @param response  The HttpServletResponse object used to return the response.
		 * @param studentId The ID of the student to be deleted.
		 * @throws ServletException If an error occurs during request processing.
		 * @throws IOException      If an input or output error occurs.
		 */
		private void handleDelete(HttpServletRequest request, HttpServletResponse response, int userId)
				throws ServletException, IOException {
			boolean success = dashboardService.deleteStudent(userId);

			if (success) {
				System.out.println("Deletion successful");
			} else {
				System.out.println("Deletion failed");
			}

			// Forward to the dashboard to reflect changes
			doGet(request, response);
		}
	}