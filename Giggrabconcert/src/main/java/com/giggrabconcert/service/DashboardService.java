package com.giggrabconcert.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.giggrabconcert.dbConfig.Dbconfig;
import com.giggrabconcert.model.TicketModel;
import com.giggrabconcert.model.UserModel;

public class DashboardService {

    private Connection dbConn;
    private boolean isConnectionError = false;

    public DashboardService() {
        try {
            dbConn = Dbconfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
            isConnectionError = true;
        }
    }

    public List<UserModel> getAllUsersInfo() {
        if (isConnectionError) {
            System.out.println("Connection Error!");
            return null;
        }

        String query = "SELECT full_name, email, number, password, username, ticket_id FROM user";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();
            List<UserModel> userList = new ArrayList<>();
            while (result.next()) {
                String ticketQuery = "SELECT ticket_id, eventName, price FROM ticket WHERE ticket_id = ?";
                try (PreparedStatement ticketStmt = dbConn.prepareStatement(ticketQuery)) {
                    ticketStmt.setInt(1, result.getInt("ticket_id"));
                    try (ResultSet ticketResult = ticketStmt.executeQuery()) {
                        TicketModel ticketModel = new TicketModel();
                        if (ticketResult.next()) {
                            ticketModel.setTicketId(ticketResult.getInt("ticket_id"));
                            ticketModel.setEventName(ticketResult.getString("eventName"));
                            ticketModel.setPrice(ticketResult.getDouble("price"));
                        }
                        userList.add(new UserModel(
                                result.getString("full_name"),
                                result.getString("email"),
                                result.getString("number"),
                                result.getString("password"),
                                result.getString("username"),
                                ticketModel
                        ));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserModel> getRecentStudents() {
        if (isConnectionError) {
            System.out.println("Connection Error!");
            return null;
        }

        String query = "SELECT full_name, email, number, password, username, ticket_id " +
                "FROM user ORDER BY user_id DESC LIMIT 3";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            ResultSet result = stmt.executeQuery();
            List<UserModel> userList = new ArrayList<>();

            while (result.next()) {
                String ticketQuery = "SELECT ticket_id, eventName, price FROM ticket WHERE ticket_id = ?";
                try (PreparedStatement ticketStmt = dbConn.prepareStatement(ticketQuery)) {
                    ticketStmt.setInt(1, result.getInt("ticket_id"));
                    try (ResultSet ticketResult = ticketStmt.executeQuery()) {
                        TicketModel ticketModel = new TicketModel();
                        if (ticketResult.next()) {
                            ticketModel.setEventName(ticketResult.getString("eventName"));
                            ticketModel.setTicketId(ticketResult.getInt("ticket_id"));
                            ticketModel.setPrice(ticketResult.getDouble("price"));
                        }
                        userList.add(new UserModel(
                                result.getString("full_name"),
                                result.getString("email"),
                                result.getString("number"),
                                result.getString("password"),
                                result.getString("username"),
                                ticketModel
                        ));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateStudent(UserModel user) {
        if (isConnectionError) {
            return false;
        }

        String updateQuery = "UPDATE user SET email = ?, username = ?, number = ?, ticket_id = ? WHERE full_name = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(updateQuery)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getNumber());
            stmt.setInt(4, getTicketId(user.getTicket().getEventName()));
            stmt.setString(5, user.getFullname());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStudent(int studentId) {
        if (isConnectionError) {
            return false;
        }

        String deleteQuery = "DELETE FROM user WHERE user_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, studentId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getEventName(int id) {
        if (isConnectionError) {
            return null;
        }

        String query = "SELECT eventName FROM ticket WHERE ticket_id = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("eventName");
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTicketId(String name) {
        if (isConnectionError) {
            return -1;
        }

        String query = "SELECT ticket_id FROM ticket WHERE eventName = ?";
        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, name);

            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getInt("ticket_id");
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public String getTotalStudents() {
        if (isConnectionError) {
            return null;
        }

        String countQuery = "SELECT COUNT(*) AS total FROM user";
        try (PreparedStatement stmt = dbConn.prepareStatement(countQuery)) {
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("total");
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getComputingStudents() {
        if (isConnectionError) {
            return null;
        }

        String countQuery = "SELECT COUNT(*) AS total FROM user WHERE ticket_id = 1";
        try (PreparedStatement stmt = dbConn.prepareStatement(countQuery)) {
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("total");
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getArijitSinghConcert() {
        if (isConnectionError) {
            return null;
        }

        String countQuery = "SELECT COUNT(*) AS total FROM user WHERE ticket_id = 2";
        try (PreparedStatement stmt = dbConn.prepareStatement(countQuery)) {
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("total");
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getShreyaGhosalConcert() {
        if (isConnectionError) {
            return null;
        }

        String countQuery = "SELECT COUNT(*) AS total FROM user WHERE ticket_id = 3";
        try (PreparedStatement stmt = dbConn.prepareStatement(countQuery)) {
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                return result.getString("total");
            } else {
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to close the database connection
    public void closeConnection() {
        if (dbConn != null) {
            try {
                dbConn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




