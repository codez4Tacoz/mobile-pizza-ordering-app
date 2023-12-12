package com.cahill.pizza.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="address")
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private Integer id;
    private String address1;
    private String address2;
    private String city;
    //TODO make this an enum or db lookup table in order to add serverside validation
    private String state;
    //private AddressType type;
    private String zip;

}
