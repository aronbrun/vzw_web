package com.website.vzw;

import javax.persistence.*;

@Entity
public class Cancellation {
    private int idCancellation;
    private int clientIdClient;
    private int courseIdCourse;

    @Id
    @Column(name = "idCancellation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdCancellation() {
        return idCancellation;
    }

    public void setIdCancellation(int idCancellation) {
        this.idCancellation = idCancellation;
    }

    @Basic
    @Column(name = "Client_idClient")
    public int getClientIdClient() {
        return clientIdClient;
    }

    public void setClientIdClient(int clientIdClient) {
        this.clientIdClient = clientIdClient;
    }

    @Basic
    @Column(name = "Course_idCourse")
    public int getCourseIdCourse() {
        return courseIdCourse;
    }

    public void setCourseIdCourse(int courseIdCourse) {
        this.courseIdCourse = courseIdCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cancellation that = (Cancellation) o;

        if (idCancellation != that.idCancellation) return false;
        if (clientIdClient != that.clientIdClient) return false;
        if (courseIdCourse != that.courseIdCourse) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCancellation;
        result = 31 * result + clientIdClient;
        result = 31 * result + courseIdCourse;
        return result;
    }
}
