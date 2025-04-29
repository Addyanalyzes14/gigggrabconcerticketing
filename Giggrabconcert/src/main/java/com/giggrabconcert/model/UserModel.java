package com.giggrabconcert.model; 


public class UserModel {
	private String fullname;
	private String email;
	private String number;
	private String password;
	private String username;
	private TicketModel ticket;
	// No-argument constructor
    public UserModel() {
    }

    // Constructor with email and password
    public UserModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Constructor with all fields
    public UserModel(String fullname, String email, String number, String password, String username,
                     TicketModel ticket) {
        this.fullname = fullname;
        this.email = email;
        this.number = number;
        this.password = password;
        this.username = username;
        this.ticket = ticket;
    }

    // Getters and setters for all variables

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TicketModel getTicket() {
        return ticket;
    }

    public void setTicket(TicketModel ticket) {
        this.ticket = ticket;
    }
}

	