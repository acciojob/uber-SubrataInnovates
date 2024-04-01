package com.driver.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cabNumber;
    private Integer perKmRate;
//    private boolean available;
    private boolean cabUnavlbl;

    @OneToOne(mappedBy = "cab", cascade = CascadeType.ALL)
    private Driver driver;

    @OneToMany(mappedBy = "cab", cascade = CascadeType.ALL)
    private List<TripBooking> tripBookings;

    @OneToMany(mappedBy = "cab", cascade = CascadeType.ALL)
    private List<Customer> customers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}

	public Integer getPerKmRate() {
		return perKmRate;
	}

	public void setPerKmRate(Integer perKmRate) {
		this.perKmRate = perKmRate;
	}

//	public boolean isAvailable() {
//		return available;
//	}

//	public void setAvailable(boolean available) {
//		this.available = available;
//	}

	public boolean isCabUnavlbl() {
		return cabUnavlbl;
	}

	public void setCabUnavlbl(boolean cabUnavlbl) {
		this.cabUnavlbl = cabUnavlbl;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public List<TripBooking> getTripBookings() {
		return tripBookings;
	}

	public void setTripBookings(List<TripBooking> tripBookings) {
		this.tripBookings = tripBookings;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Cab(Integer id, String cabNumber, Integer perKmRate, boolean cabUnavlbl, Driver driver,
			List<TripBooking> tripBookings, List<Customer> customers) {
		
		this.id = id;
		this.cabNumber = cabNumber;
		this.perKmRate = perKmRate;
		//this.available = available;
		this.cabUnavlbl = cabUnavlbl;
		this.driver = driver;
		this.tripBookings = tripBookings;
		this.customers = customers;
	}

	public Cab() {
		
		// TODO Auto-generated constructor stub
	}
    
    

    
}
