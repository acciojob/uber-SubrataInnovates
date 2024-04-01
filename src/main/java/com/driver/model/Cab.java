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
    private boolean available;

    @OneToMany(mappedBy = "cab", cascade = CascadeType.ALL)
    private List<Driver> drivers;

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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
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

    public Cab(Integer id, String cabNumber, Integer perKmRate, boolean available, List<Driver> drivers, List<TripBooking> tripBookings, List<Customer> customers) {
        this.id = id;
        this.cabNumber = cabNumber;
        this.perKmRate = perKmRate;
        this.available = available;
        this.drivers = drivers;
        this.tripBookings = tripBookings;
        this.customers = customers;
    }

    public Cab() {
    }
}
