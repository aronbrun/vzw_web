package com.website.vzw.Address;

import javax.persistence.*;

@Entity
public class Address {
    private int idAddress;
    private String address;
    private int fkCity;

    @Id
    @Column(name = "idAddress")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "fk_City")
    public int getFkCity() {
        return fkCity;
    }

    public void setFkCity(int fkCity) {
        this.fkCity = fkCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address1 = (Address) o;

        if (idAddress != address1.idAddress) return false;
        if (fkCity != address1.fkCity) return false;
        if (address != null ? !address.equals(address1.address) : address1.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAddress;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + fkCity;
        return result;
    }
}
