package com.driver.model;

import javax.persistence.*;

@Entity
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripBookingId;

    private String fromLocation;
    private String toLocation;
    private int distanceInKm;
    private int bill;

    @Enumerated(EnumType.STRING)
    private TripStatus status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    
    @ManyToOne
    @JoinColumn
    private Cab cab;

	public Integer getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(Integer tripBookingId) {
		this.tripBookingId = tripBookingId;
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

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
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

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public TripBooking(Integer tripBookingId, String fromLocation, String toLocation, int distanceInKm, int bill,
			TripStatus status, Customer customer, Driver driver, Cab cab) {
		super();
		this.tripBookingId = tripBookingId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		this.status = status;
		this.customer = customer;
		this.driver = driver;
		this.cab = cab;
	}

	public TripBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void calculateBill() {
		double perKmRate = this.driver.getCab().getPerKmRate(); 
        this.bill = (int) (perKmRate * this.distanceInKm);
		
	}

	
	

    
}
