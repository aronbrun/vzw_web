package com.website.vzw;

import javax.persistence.*;

@Entity
public class Competition {
    private int idCompetition;
    private int fkEventInformation;
    private String category;

    @Id
    @Column(name = "idCompetition")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdCompetition() {
        return idCompetition;
    }

    public void setIdCompetition(int idCompetition) {
        this.idCompetition = idCompetition;
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
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Competition that = (Competition) o;

        if (idCompetition != that.idCompetition) return false;
        if (fkEventInformation != that.fkEventInformation) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCompetition;
        result = 31 * result + fkEventInformation;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }
}
