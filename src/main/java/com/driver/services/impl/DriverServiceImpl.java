package com.driver.services.impl;

import com.driver.model.Cab;
import com.driver.repository.CabRepository;
import com.driver.services.DriverService;
import com.driver.model.Driver;
import com.driver.repository.DriverRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CabRepository cabRepository;

    @Override
    public void register(String mobile, String password){
        // Save a driver in the database having given details and a cab with ratePerKm as 10 and availability as True by default.

        Driver driver = new Driver();
        driver.setMobile(mobile);
        driver.setPassword(password);
        
        Cab cab = new Cab();
        cab.setPerKmRate(10);
        cab.setCabUnavlbl(true); // Newly registered drivers have their cabs available by default
        driver.setCab(cab);
        
        driverRepository.save(driver);
    }

    @Override
    public void removeDriver(int driverId) 
    {
        // Remove driver without deleteById
        
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isPresent()) {
            driverRepository.delete(optionalDriver.get());
        } else {
            throw new RuntimeException("Driver not found with id " + driverId);
        }
    }

    @Override
    public void updateStatus(int driverId){
        // Set the status of respective car to unavailable
        
        Optional<Driver> optionalDriver = driverRepository.findById(driverId);
        if (optionalDriver.isPresent()) {
            Driver driver = optionalDriver.get();
            Cab cab = driver.getCab();
            cab.setCabUnavlbl(false); // Setting cab availability to false
            cabRepository.save(cab); // Save the changes to the cab
        } else {
            throw new RuntimeException("Driver not found with id " + driverId);
        }   
    }
}
