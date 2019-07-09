package com.website.vzw;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class EventInformation {
    private int idEventInformation;
    private Date startdate;
    private Date enddate;
    private String name;
    private String links;

    @Id
    @Column(name = "idEventInformation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdEventInformation() {
        return idEventInformation;
    }

    public void setIdEventInformation(int idEventInformation) {
        this.idEventInformation = idEventInformation;
    }

    @Basic
    @Column(name = "startdate")
    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    @Basic
    @Column(name = "enddate")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "links")
    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventInformation that = (EventInformation) o;

        if (idEventInformation != that.idEventInformation) return false;
        if (startdate != null ? !startdate.equals(that.startdate) : that.startdate != null) return false;
        if (enddate != null ? !enddate.equals(that.enddate) : that.enddate != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (links != null ? !links.equals(that.links) : that.links != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEventInformation;
        result = 31 * result + (startdate != null ? startdate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }
}
