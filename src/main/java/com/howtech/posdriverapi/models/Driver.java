package com.howtech.posdriverapi.models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Damond Howard
 * @apiNote this entity maps a driver
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name="drivers")
public class Driver extends Person{
    @Id
    @GeneratedValue
    @Column(name = "driver_id")
    private Long driverId;
    @Column(name = "username")
    private String username;
    @Column(name = "profile_img_url")
    private String driverProfileImg;
    @Column(name = "completed_trips")
    private int completedTrips;
    @Column(name = "number_of_ratings")
    private int ratings;
    @Column(name = "rating")
    private int rating;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "online_status")
    private boolean online;
    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false )
    @ToString.Exclude
    private DriverDepositInfo driverDepositInfo;
    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false )
    @ToString.Exclude
    private DriverVehicle driverVehicle;
    @OneToOne(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false )
    @ToString.Exclude
    private DriverLocation driverLocation;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    private Set<DriverOrder> driverOrders;
    @OneToMany(mappedBy = "driver", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @ToString.Exclude
    private Set<DriverShipment> driverShipments;

    public void setDriverVehicle(DriverVehicle driverVehicle) {
        if (driverVehicle == null) {
            if (this.driverVehicle != null) {
                this.driverVehicle.setDriver(null);
            }
        } else {
            driverVehicle.setDriver(this);
        }
        this.driverVehicle = driverVehicle;
    }

    public void setDriverLocation(DriverLocation driverLocation) {
        if (driverLocation == null) {
            if (this.driverLocation != null) {
                this.driverLocation.setDriver(null);
            }
        } else {
            driverLocation.setDriver(this);
        }
        this.driverLocation = driverLocation;
    }

    public void setDriverDepositInfo(DriverDepositInfo driverDepositInfo) {
        if (driverDepositInfo == null) {
            if (this.driverDepositInfo != null) {
                this.driverDepositInfo.setDriver(null);
            }
        } else {
            driverDepositInfo.setDriver(this);
        }
        this.driverDepositInfo = driverDepositInfo;
    }

    public void addDriverOrder(DriverOrder driverOrder) {
        driverOrders.add(driverOrder);
        driverOrder.setDriver(this);
    }

    public void removeDriverOrder(DriverOrder driverOrder) {
        driverOrders.remove(driverOrder);
        driverOrder.setDriver(null);
    }

    public void addDriverShipment(DriverShipment driverShipment) {
        driverShipments.add(driverShipment);
        driverShipment.setDriver(this);
    }

    public void removeDriverShipment(DriverShipment driverShipment) {
        driverShipments.remove(driverShipment);
        driverShipment.setDriver(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Driver driver = (Driver) o;
        return driverId != null && Objects.equals(driverId, driver.driverId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}