package com.howtech.posdriverapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.howtech.posdriverapi.models.enums.ShipmentStatus;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author Damond Howard
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "driver_shipments")
public class DriverShipment {
    @Id
    @GeneratedValue
    @Column(name = "driver_shipment_id")
    private Long driverShipmentId;
    @Enumerated
    @Column(name = "shipment_status")
    private ShipmentStatus shipmentStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DriverShipment that = (DriverShipment) o;
        return driverShipmentId != null && Objects.equals(driverShipmentId, that.driverShipmentId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}