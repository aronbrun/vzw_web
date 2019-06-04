package com.website.vzw.City;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCity")
    private Long idCity;

    @Column(name = "postCode")
    private String postCode;

    @Column(name = "name")
    private String name;

    public City(String postCode, String name) {
        this.postCode = postCode;
        this.name = name;
    }

    public City() {}

    public Long getIdCity() {
        return idCity;
    }

    public void setIdCity(Long idCity) {
        this.idCity = idCity;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}