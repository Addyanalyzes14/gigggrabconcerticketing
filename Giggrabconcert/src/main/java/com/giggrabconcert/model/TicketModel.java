package com.giggrabconcert.model;

public class TicketModel {
    private int ticketId;
    private String eventName;
    private double price; // Adjusted to double (or int, depending on schema)

    // No-argument constructor
    public TicketModel() {
    }

    // Parameterized constructor (if needed)
    public TicketModel(int ticketId, String eventName, double price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.price = price;
    }

    // Getters and setters
    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
