package com.eDMS.letterArchive.domain.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
public class Address {
    @EmbeddedId
    private AddressId id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String houseNumber;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String city;

    Address() {
    }

    public Address(String street, String houseNumber, String postalCode, String city) {
        this.id = new AddressId();
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public AddressId getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
