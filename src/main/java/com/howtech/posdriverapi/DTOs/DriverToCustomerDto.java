package com.howtech.posdriverapi.DTOs;
import java.math.BigDecimal;

import lombok.Data;

/**
 *
 * @author Damond Howard
 * @apiNote This is a DTO object for transferring driver info to the customer
 *
 */
@Data
public class DriverToCustomerDto {

    private BigDecimal longitude;
    private BigDecimal lattitude;
    private String firstName;
    private String driverProfileImg;
    private String licensePlate;
    private String make;
    private String model;
    private String color;
    private int completedTrips;
    private int ratings;
    private int rating;
    /* TODO a way to contact the driver from customer */
}
