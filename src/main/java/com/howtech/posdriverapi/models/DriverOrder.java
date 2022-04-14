package com.howtech.posdriverapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "driver_orders")
public class DriverOrder {
    @Id
    @GeneratedValue
    @Column(name = "driver_order_id")
    private Long driverOrderId;
    @Column(name = "store_id")
    private Long storeId;
    @Column(name = "customer_id")
    private long customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "order_date")
    private Date orderDate;
    @ElementCollection
    protected Set<Long> cartItems;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ToString.Exclude
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DriverOrder that = (DriverOrder) o;
        return driverOrderId != null && Objects.equals(driverOrderId, that.driverOrderId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}