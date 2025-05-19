package com.giggrabconcert.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.giggrabconcert.dbConfig.Dbconfig;
import com.giggrabconcert.model.UserModel;

public class RegisterService {

    private Connection dbConn;

    public RegisterService() {
        try {
            this.dbConn = Dbconfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println("Database connection error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Boolean addUser(UserModel userModel) {
        if (dbConn == null) {
            System.err.println("Database connection is not available.");
            return null;
        }

        String ticketQuery = "SELECT ticket_id FROM ticket WHERE name = ?";
        String insertQuery = "INSERT INTO student (full_name, username, email, number, password, ticket_id) "
                           + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ticketStmt = dbConn.prepareStatement(ticketQuery);
             PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {

            // Get ticket_id by ticket name
            ticketStmt.setString(1, userModel.getTicket().getEventName());
            ResultSet result = ticketStmt.executeQuery();
            int ticketId = result.next() ? result.getInt("ticket_id") : 1;

            // Insert user
            insertStmt.setString(1, userModel.getFullname());
            insertStmt.setString(2, userModel.getUsername());
            insertStmt.setString(3, userModel.getEmail());
            insertStmt.setString(4, userModel.getNumber());
            insertStmt.setString(5, userModel.getPassword());
            insertStmt.setInt(6, ticketId);

            return insertStmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error during student registration: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
