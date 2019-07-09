package com.website.vzw;

import javax.persistence.*;

@Entity
public class Registration {
    private int idRegistration;
    private int fkClient;
    private int fkCourse;
    private int status;

    @Id
    @Column(name = "idRegistration")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(int idRegistration) {
        this.idRegistration = idRegistration;
    }

    @Basic
    @Column(name = "fk_Client")
    public int getFkClient() {
        return fkClient;
    }

    public void setFkClient(int fkClient) {
        this.fkClient = fkClient;
    }

    @Basic
    @Column(name = "fk_Course")
    public int getFkCourse() {
        return fkCourse;
    }

    public void setFkCourse(int fkCourse) {
        this.fkCourse = fkCourse;
    }

    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        if (idRegistration != that.idRegistration) return false;
        if (fkClient != that.fkClient) return false;
        if (fkCourse != that.fkCourse) return false;
        if (status != that.status) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegistration;
        result = 31 * result + fkClient;
        result = 31 * result + fkCourse;
        result = 31 * result + status;
        return result;
    }
}
