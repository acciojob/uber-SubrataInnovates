package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    
    private String name;
    
    @OneToOne
    private Cab cab;
    
    @OneToOne
    private TripBooking tripBooking;
    
    @OneToOne
    private Driver driver;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public TripBooking getTripBooking() {
		return tripBooking;
	}

	public void setTripBooking(TripBooking tripBooking) {
		this.tripBooking = tripBooking;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Customer(Integer customerId, String name, Cab cab, TripBooking tripBooking, Driver driver) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.cab = cab;
		this.tripBooking = tripBooking;
		this.driver = driver;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
