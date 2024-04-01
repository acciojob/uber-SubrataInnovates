package com.driver.services.impl;

import com.driver.model.TripBooking;
import com.driver.services.CustomerService;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;
import com.driver.repository.TripBookingRepository;
import com.driver.model.TripStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private TripBookingRepository tripBookingRepository;

    @Override
    public void register(Customer customer) {
        // Save the customer in the database
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        // Delete customer without using deleteById function
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
        customerRepository.delete(customer);
    }

    @Override
    public TripBooking bookTrip(int customerId, String fromLocation, String toLocation, int distanceInKm) throws Exception {
        // Book the driver with the lowest driverId who is free (cab available variable is Boolean.TRUE).
        // If no driver is available, throw "No cab available!" exception

        List<Driver> availableDrivers = driverRepository.findByCabCabUnavlbl(false); // Find available drivers

        if (availableDrivers.isEmpty()) {
            throw new Exception("No cab available!");
        }

        // Select the first available driver from the list
        Driver driver = availableDrivers.get(0);

        TripBooking tripBooking = new TripBooking();
        tripBooking.setDistanceInKm(distanceInKm);
        tripBooking.setDriver(driver);
        tripBooking.setFromLocation(fromLocation);
        tripBooking.setToLocation(toLocation);
        tripBooking.setStatus(TripStatus.CONFIRMED);
        tripBooking.calculateBill();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + customerId));
        tripBooking.setCustomer(customer);

        return tripBookingRepository.save(tripBooking);
    }

    @Override
    public void cancelTrip(Integer tripId) {
        // Cancel the trip having given trip Id and update TripBooking attributes accordingly
        TripBooking tripBooking = tripBookingRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("TripBooking not found with id " + tripId));
        tripBooking.setStatus(TripStatus.CANCELED);
        tripBooking.setBill(0);
        tripBookingRepository.save(tripBooking);
    }

    @Override
    public void completeTrip(Integer tripId) {
        // Complete the trip having given trip Id and update TripBooking attributes accordingly
        TripBooking tripBooking = tripBookingRepository.findById(tripId)
                .orElseThrow(() -> new RuntimeException("TripBooking not found with id " + tripId));
        tripBooking.setStatus(TripStatus.COMPLETED);
        tripBookingRepository.save(tripBooking);
    }
}
