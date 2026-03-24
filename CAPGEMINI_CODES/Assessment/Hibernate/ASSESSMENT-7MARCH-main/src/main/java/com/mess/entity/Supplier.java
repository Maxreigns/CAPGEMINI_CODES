package com.mess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;

    private String sname;

    private String city;

    private int srank;

    // Constructors
    public Supplier() {}

    public Supplier(String sname, String city, int srank) {
        this.sname = sname;
        this.city = city;
        this.srank = srank;
    }

    // Getters and Setters
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSrank() {
        return srank;
    }

    public void setSrank(int srank) {
        this.srank = srank;
    }
}