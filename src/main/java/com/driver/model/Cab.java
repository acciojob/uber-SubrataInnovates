package com.driver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cab
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cabId;
	private String cabNumber;
	private double ratePerKm;
	private boolean available;
	
	@JoinColumn
	@OneToOne
	private Driver driver;

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public String getCabNumber() {
		return cabNumber;
	}

	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}

	public double getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(double ratePerKm) {
		this.ratePerKm = ratePerKm;
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

	public Cab(Integer cabId, String cabNumber, double ratePerKm, boolean available, Driver driver) {
		super();
		this.cabId = cabId;
		this.cabNumber = cabNumber;
		this.ratePerKm = ratePerKm;
		this.available = available;
		this.driver = driver;
	}

	public Cab() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}