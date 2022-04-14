package com.howtech.posdriverapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "driver_vehicles")
public class DriverVehicle {
    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    private Long vehicleId;
    @Column(name = "car_make")
    private String make;
    @Column(name = "car_model")
    private String model;
    @Column(name = "color")
    private String vehicleColor;
    @Column(name = "license_plate")
    private String licensePlate;
    @Column(name = "license_number")
    private Long driversLicense;
    @Column(name = "approved")
    private boolean approvedToDrive;
    @OneToOne
    @JsonIgnore
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DriverVehicle that = (DriverVehicle) o;
        return vehicleId != null && Objects.equals(vehicleId, that.vehicleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}