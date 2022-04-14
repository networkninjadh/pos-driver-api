package com.howtech.posdriverapi.DTOs;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Damond Howard
 * @apiNote This is a DTO object for transferring the drivers' information to a store
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverToStoreDto {

    private BigDecimal longitude;
    private BigDecimal latitude;
    private String firstName;
    private String driverProfileImg;
    private String licensePlate;
    private String make;
    private String model;
    private String color;
    private int completedTrips;
    private int ratings;
    private int rating;
    //a way to contact the driver
}
