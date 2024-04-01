package com.driver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cab
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String cabNumber;
	private Integer perKmRate;
	private boolean available;
	
	
	@JoinColumn
	@OneToOne
	private Driver driver;

	@JoinColumn 
	@OneToMany
	private List<TripBooking> tripBookings;
	
	@JoinColumn
	@OneToMany
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
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

	public Cab(Integer id, String cabNumber, Integer perKmRate, boolean available, Driver driver,
			List<TripBooking> tripBookings, List<Customer> customers) {
		super();
		this.id = id;
		this.cabNumber = cabNumber;
		this.perKmRate = perKmRate;
		this.available = available;
		this.driver = driver;
		this.tripBookings = tripBookings;
		this.customers = customers;
	}

	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
}