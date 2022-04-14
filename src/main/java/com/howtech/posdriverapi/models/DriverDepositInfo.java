package com.howtech.posdriverapi.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 *
 * @author Damond Howard
 * @apiNote This Entity contains all the data for Stripe to deposit into the drivers account
 *
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "driver_deposit_info")
public class DriverDepositInfo {
    @Id
    @GeneratedValue
    @Column(name = "deposit_info_id")
    private Long depositInfoId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driver_id")
    @JsonIgnore
    @ToString.Exclude
    private Driver driver;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DriverDepositInfo that = (DriverDepositInfo) o;
        return depositInfoId != null && Objects.equals(depositInfoId, that.depositInfoId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}