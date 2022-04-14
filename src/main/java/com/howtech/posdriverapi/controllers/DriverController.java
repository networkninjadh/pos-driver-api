package com.howtech.posdriverapi.controllers;

import java.util.List;

import com.howtech.posdriverapi.DTOs.DriverDto;
import com.howtech.posdriverapi.DTOs.UserInfo;
import com.howtech.posdriverapi.exceptions.DriverNotFoundException;
import com.howtech.posdriverapi.models.Driver;
import com.howtech.posdriverapi.models.DriverLocation;
import com.howtech.posdriverapi.services.DriverService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Damond Howard
 * @apiNote this is a Restful API that exposes endpoints for creating updating
 *          getting and deleting a driver as well as a list of drivers
 *
 */
@RestController
@RequestMapping(path = "/driver-api/")
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     *
     * @param driver a driver object
     * @param userInfo user info object from pos-auth-api
     * @return the Driver object representing the Driver that was saved to the
     *         database
     */
    @PostMapping(path = "/driver/new")
    public Driver addDriver(@RequestBody DriverDto driver, UserInfo userInfo) {
        return driverService.addDriver(driver, userInfo);
    }

    /**
     *
     * @param driverId the ID of the driver
     * @param userInfo user info object from pos-auth-api
     * @return the location object for the driver's current position
     * @throws DriverNotFoundException when driver with ID driverId is not found in the database
     */
    @PostMapping("/driver/{driver_id}/location")
    public DriverLocation getDriverLocation(@PathVariable(name = "driver_id") Long driverId,
                                            UserInfo userInfo) throws DriverNotFoundException {
        return driverService.getDriverLocation(driverId);
    }

    /**
     *
     * @param driverId the ID of the driver
     * @param userInfo user info object from pos-auth-api
     * @param driverLocation the current location of the driver
     * @return the driver whose location was just set
     * @throws DriverNotFoundException because a driver with ID driverId was not found
     */
    @GetMapping("/driver/{driver_id}/location")
    public Driver setDriverLocation(@PathVariable(name = "driver_id") Long driverId,
                                    UserInfo userInfo, @RequestBody DriverLocation driverLocation)
            throws DriverNotFoundException {
        return driverService.setDriverLocation(driverId, driverLocation, userInfo);
    }

    /**
     *
     * @param userInfo the user's information from pos-auth-api
     * @return the current logged in drivers Driver object using the current
     *         security context from the logged-in user
     * @throws DriverNotFoundException because a driver with ID driverId was not found
     */
    @GetMapping("/me")
    public Driver getMyDriverInfo(UserInfo userInfo) throws DriverNotFoundException {
        return driverService.getMyDriverInfo(userInfo);
    }

    /**
     *
     * @param driverId the ID of the driver
     * @return return a Driver object based off the id
     * @throws DriverNotFoundException because a driver with ID driverId was not found
     */
    @GetMapping("/driver/{driver_id}")
    public Driver getDriver(@PathVariable Long driverId) throws DriverNotFoundException {
        return driverService.getDriver(driverId);
    }

    /**
     *
     * @return the complete list of drivers stored in the database
     */
    @GetMapping("/drivers")
    public List<Driver> getDrivers(UserInfo userInfo) {
        return driverService.getDrivers(userInfo);
    }

    /**
     *
     * @param driverId the ID of the driver
     * @return a String message confirming that the Driver with id {id} has been
     *         deleted
     */
    @DeleteMapping("/delete/{driver_id}")
    public String deleteDriver(@PathVariable Long driverId, UserInfo userInfo) {
        return driverService.deleteDriver(driverId, userInfo);
    }

    /**
     *
     * @return a String message confirming that every driver in the database has been
     *         deleted
     */
    @DeleteMapping("/driver/delete/all")
    public String delete(UserInfo userInfo) {
        return driverService.delete(userInfo);
    }

    /* TODO controllers for returning available store pickups to driver */
}