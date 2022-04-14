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
@Table(name = "driver_locations")
public class DriverLocation {

    @Id
    @GeneratedValue
    private Long driverLocationId;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    @JsonIgnore
    @ToString.Exclude
    Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DriverLocation that = (DriverLocation) o;
        return driverLocationId != null && Objects.equals(driverLocationId, that.driverLocationId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
