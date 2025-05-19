package com.giggrabconcert.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.giggrabconcert.model.UserModel;
import com.giggrabconcert.model.TicketModel;
import com.giggrabconcert.service.DashboardService;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/dashboardController" })
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Instance of DashboardService for handling business logic
		private DashboardService dashboardService;

		/**
		 * Default constructor initializes the DashboardService instance.
		 */
		public DashboardController() {
			this.dashboardService = new DashboardService();
		}

		/**
		 * Handles HTTP GET requests by retrieving student information and forwarding
		 * the request to the dashboard JSP page.
		 * 
		 * @param request  The HttpServletRequest object containing the request data.
		 * @param response The HttpServletResponse object used to return the response.
		 * @throws ServletException If an error occurs during request processing.
		 * @throws IOException      If an input or output error occurs.
		 */
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Retrieve all student information from the DashboardService
			request.setAttribute("userList", dashboardService.getRecentUsers());
         	request.setAttribute("total", dashboardService.getTotalUsers());
			request.setAttribute("arijitsinghconert", dashboardService.getArijitSinghConcert());
			request.setAttribute("shreyaghosalconcert", dashboardService.getShreyaGhosalConcert());
		

			// Forward the request to the dashboard JSP for rendering
			request.getRequestDispatcher("/WEB-INF/pages/admin/dashboard.jsp").forward(request, response);
		}

	}