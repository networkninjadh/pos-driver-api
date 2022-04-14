package com.howtech.posdriverapi.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Damond Howard
 * @apiNote base class person for creating other types of people including employees, customers, and drivers
 *
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class Person {
    @Column(name = "first_name")
    protected String firstName;
    @Column(name = "middle_name")
    protected String middleName;
    @Column(name = "last_name")
    protected String lastName;
    @Column(name = "email")
    protected String email;
}