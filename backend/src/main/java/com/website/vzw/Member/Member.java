package com.website.vzw.Member;

import javax.persistence.*;

@Entity
public class Member {
    private int idMember;
    private int fkUser;
    private String username;
    private String password;

    @Id
    @Column(name = "idMember")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    @Basic
    @Column(name = "fk_User")
    public int getFkUser() {
        return fkUser;
    }

    public void setFkUser(int fkUser) {
        this.fkUser = fkUser;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (idMember != member.idMember) return false;
        if (fkUser != member.fkUser) return false;
        if (username != null ? !username.equals(member.username) : member.username != null) return false;
        if (password != null ? !password.equals(member.password) : member.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMember;
        result = 31 * result + fkUser;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
