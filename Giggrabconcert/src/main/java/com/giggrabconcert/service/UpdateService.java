package com.giggrabconcert.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.giggrabconcert.dbConfig.Dbconfig;
import com.giggrabconcert.model.UserModel;



/**
 * Service class for updating student information in the database.
 * 
 * This class provides methods to update student details and fetch program IDs
 * from the database. It manages database connections and handles SQL
 * exceptions.
 */
public class UpdateService {
	private Connection dbConn;
	private boolean isConnectionError = false;

	/**
	 * Constructor initializes the database connection. Sets the connection error
	 * flag if the connection fails.
	 */
	public UpdateService() {
		try {
			dbConn = Dbconfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			// Log and handle exceptions related to database connection
			ex.printStackTrace();
			isConnectionError = true;
		}
	}

	/**
	 * Updates student information in the database.
	 * 
	 * @param student The StudentModel object containing the updated student data.
	 * @return Boolean indicating the success of the update operation. Returns null
	 *         if there is a connection error or an exception occurs.
	 */
	public Boolean updateUserInfo(UserModel user) {
		if (isConnectionError) {
			return null;
		}

		int ticketId = TicketId(user.getTicket().getEventName());
		if (ticketId == 0) {
			// Handle case where the program is not found in the database
			System.out.println("Invalid ticket: " + user.getTicket().getEventName());
			return false; // or return null if you want to handle this in the controller
		}

		String updateSQL = "UPDATE user SET full_name = ?, email=? , program_id = ?, "
				+ "email = ?, number = ? WHERE student_id = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(updateSQL)) {
			preparedStatement.setString(1, user.getFullname());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setInt(3, ticketId);
			preparedStatement.setString(4, user.getNumber());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getUsername());

			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			// Log and handle SQL exceptions
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Retrieves the program ID for a given program name.
	 * 
	 * @param programName The name of the program.
	 * @return The ID of the program. Returns 0 if the program is not found or an
	 *         exception occurs.
	 */
	private int TicketId(String eventName) {
		String selectSQL = "SELECT ticket_id FROM ticket WHERE eventName = ?";

		try (PreparedStatement preparedStatement = dbConn.prepareStatement(selectSQL)) {
			preparedStatement.setString(1, eventName);
			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				return result.getInt("ticket_id");
			}
		} catch (SQLException e) {
			// Log and handle SQL exceptions
			e.printStackTrace();
		}

		return 0;
	}
}