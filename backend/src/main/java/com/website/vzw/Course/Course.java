package com.website.vzw;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Course {
    private int idCourse;
    private String name;
    private int fkCategory;
    private String weekday;
    private Date startate;
    private Date enddate;
    private Time starttime;
    private Time endtime;
    private String cancellationDates;
    private int lessonNumber;
    private int costs;
    private int maxRegistration;

    @Id
    @Column(name = "idCourse")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
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
    @Column(name = "fk_Category")
    public int getFkCategory() {
        return fkCategory;
    }

    public void setFkCategory(int fkCategory) {
        this.fkCategory = fkCategory;
    }

    @Basic
    @Column(name = "weekday")
    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    @Basic
    @Column(name = "startate")
    public Date getStartate() {
        return startate;
    }

    public void setStartate(Date startate) {
        this.startate = startate;
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
    @Column(name = "starttime")
    public Time getStarttime() {
        return starttime;
    }

    public void setStarttime(Time starttime) {
        this.starttime = starttime;
    }

    @Basic
    @Column(name = "endtime")
    public Time getEndtime() {
        return endtime;
    }

    public void setEndtime(Time endtime) {
        this.endtime = endtime;
    }

    @Basic
    @Column(name = "cancellationDates")
    public String getCancellationDates() {
        return cancellationDates;
    }

    public void setCancellationDates(String cancellationDates) {
        this.cancellationDates = cancellationDates;
    }

    @Basic
    @Column(name = "lessonNumber")
    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    @Basic
    @Column(name = "costs")
    public int getCosts() {
        return costs;
    }

    public void setCosts(int costs) {
        this.costs = costs;
    }

    @Basic
    @Column(name = "maxRegistration")
    public int getMaxRegistration() {
        return maxRegistration;
    }

    public void setMaxRegistration(int maxRegistration) {
        this.maxRegistration = maxRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (idCourse != course.idCourse) return false;
        if (fkCategory != course.fkCategory) return false;
        if (lessonNumber != course.lessonNumber) return false;
        if (costs != course.costs) return false;
        if (maxRegistration != course.maxRegistration) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (weekday != null ? !weekday.equals(course.weekday) : course.weekday != null) return false;
        if (startate != null ? !startate.equals(course.startate) : course.startate != null) return false;
        if (enddate != null ? !enddate.equals(course.enddate) : course.enddate != null) return false;
        if (starttime != null ? !starttime.equals(course.starttime) : course.starttime != null) return false;
        if (endtime != null ? !endtime.equals(course.endtime) : course.endtime != null) return false;
        if (cancellationDates != null ? !cancellationDates.equals(course.cancellationDates) : course.cancellationDates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCourse;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + fkCategory;
        result = 31 * result + (weekday != null ? weekday.hashCode() : 0);
        result = 31 * result + (startate != null ? startate.hashCode() : 0);
        result = 31 * result + (enddate != null ? enddate.hashCode() : 0);
        result = 31 * result + (starttime != null ? starttime.hashCode() : 0);
        result = 31 * result + (endtime != null ? endtime.hashCode() : 0);
        result = 31 * result + (cancellationDates != null ? cancellationDates.hashCode() : 0);
        result = 31 * result + lessonNumber;
        result = 31 * result + costs;
        result = 31 * result + maxRegistration;
        return result;
    }
}
