package com.giggrabconcert.model;

public class TicketModel {  
	private String eventName; 
	private int ticketId;
    private double price; 
    
	public TicketModel(String eventName, int eventId, double price) {
		super();
		this.eventName = eventName;
	    this.ticketId = eventId;
	    this.price = price;
	}
    
	public TicketModel(String name) {
		this.eventName = name;
	}
	
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}


    public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
         

}
