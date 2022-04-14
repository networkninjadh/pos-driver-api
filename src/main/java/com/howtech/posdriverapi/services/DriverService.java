package com.howtech.posdriverapi.services;

import com.howtech.posdriverapi.DTOs.DriverDto;
import com.howtech.posdriverapi.DTOs.UserInfo;
import com.howtech.posdriverapi.exceptions.DriverNotFoundException;
import com.howtech.posdriverapi.models.Driver;
import com.howtech.posdriverapi.models.DriverLocation;
import com.howtech.posdriverapi.models.DriverVehicle;
import com.howtech.posdriverapi.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver addDriver(DriverDto driver, UserInfo userInfo) {
        Driver newDriver = new Driver();
        newDriver.setUsername(userInfo.getUsername());
        newDriver.setFirstName(driver.getFirstName());
        newDriver.setMiddleName(driver.getMiddleName());
        newDriver.setLastName(driver.getLastName());
        newDriver.setDriverProfileImg(driver.getDriverProfileImg());
        newDriver.setCompletedTrips(driver.getCompletedTrips());
        newDriver.setRatings(driver.getRating());
        newDriver.setRating(driver.getRating());
        newDriver.setPhoneNumber(driver.getPhoneNumber());
        newDriver.setOnline(false);
        DriverVehicle driverVehicle = new DriverVehicle();
        driverVehicle.setMake(driver.getMake());
        driverVehicle.setModel(driver.getModel());
        driverVehicle.setVehicleColor(driver.getVehicleColor());
        driverVehicle.setLicensePlate(driver.getLicensePlate());
        driverVehicle.setDriversLicense(driver.getDriversLicense());
        driverVehicle.setApprovedToDrive(false);
        driverVehicle.setDriver(newDriver);
        newDriver.setDriverVehicle(driverVehicle);

        return driverRepository.save(newDriver);
    }

    public DriverLocation getDriverLocation(Long driverId) throws DriverNotFoundException {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(driverId));
        return driver.getDriverLocation();
    }

    public Driver setDriverLocation(Long driverId, DriverLocation driverLocation, UserInfo userInfo)
            throws DriverNotFoundException {
        Driver driver = driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(driverId));
        return driverRepository.save(driver);
    }

    public Driver getMyDriverInfo(UserInfo userInfo) throws DriverNotFoundException {
        return driverRepository.findByUsername(userInfo.getUsername())
                .orElseThrow(() -> new DriverNotFoundException(userInfo.getUsername()));
    }

    public Driver getDriver(Long driverId) throws DriverNotFoundException {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new DriverNotFoundException(driverId));
    }

    public List<Driver> getDrivers(UserInfo userInfo) {
        return driverRepository.findAll();
    }

    public String deleteDriver(Long driverId, UserInfo userInfo) {
        driverRepository.deleteById(driverId);
        return "Driver with id " + driverId + " has been deleted";
    }

    public String delete(UserInfo userInfo) {
        driverRepository.deleteAll();
        return "All drivers have been deleted from the database";
    }

}
