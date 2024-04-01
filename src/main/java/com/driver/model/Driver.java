package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Driver {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverId;
    
    private String name;
    private String mobile;
    private String password;
    
    @OneToOne(mappedBy = "driver")
    private Cab cab;
    
    @OneToOne(mappedBy = "driver")
    private TripBooking tripBooking;
    
    @OneToOne(mappedBy = "driver")
    private Customer customer;

	public Integer getDriverId() {
		return driverId;
	}

	public void setDriverId(Integer driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver(Integer driverId, String name, String mobile, String password, Cab cab, TripBooking tripBooking,
			Customer customer) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.mobile = mobile;
		this.password = password;
		this.cab = cab;
		this.tripBooking = tripBooking;
		this.customer = customer;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
