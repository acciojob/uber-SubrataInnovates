package com.driver.model;

import javax.persistence.*;

@Entity
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripId;

    private String fromLocation;
    private String toLocation;
    private int distanceInKm;
    private double totalPrice;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

	public Integer getTripId() {
		return tripId;
	}

	public void setTripId(Integer tripId) {
		this.tripId = tripId;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public int getDistanceInKm() {
		return distanceInKm;
	}

	public void setDistanceInKm(int distanceInKm) {
		this.distanceInKm = distanceInKm;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public TripStatus getStatus() {
		return status;
	}

	public void setStatus(TripStatus status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public TripBooking(Integer tripId, String fromLocation, String toLocation, int distanceInKm, double totalPrice,
			TripStatus status, Customer customer, Driver driver) {
		super();
		this.tripId = tripId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distanceInKm = distanceInKm;
		this.totalPrice = totalPrice;
		this.status = status;
		this.customer = customer;
		this.driver = driver;
	}

	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
