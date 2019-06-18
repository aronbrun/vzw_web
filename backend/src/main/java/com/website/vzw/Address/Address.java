package com.website.vzw.Address;

import com.website.vzw.City.City;

import javax.persistence.*;


@Entity
@Table(name = "Address")
public class Address {
    // generating all attributes in table Address
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAddress")
    private Long idAddress;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "fk_City")
    private City city;

    //constructor
    public Address(String address, City city) {
        this.address = address;
        this.city = city;
    }

    public Address() {}

    // getters and setters
    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}