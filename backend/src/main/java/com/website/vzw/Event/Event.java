package com.website.vzw;

import javax.persistence.*;

@Entity
public class Event {
    private int idEvent;
    private int fkEventInformation;
    private String description;

    @Id
    @Column(name = "idEvent")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    @Basic
    @Column(name = "fk_EventInformation")
    public int getFkEventInformation() {
        return fkEventInformation;
    }

    public void setFkEventInformation(int fkEventInformation) {
        this.fkEventInformation = fkEventInformation;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (idEvent != event.idEvent) return false;
        if (fkEventInformation != event.fkEventInformation) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEvent;
        result = 31 * result + fkEventInformation;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
