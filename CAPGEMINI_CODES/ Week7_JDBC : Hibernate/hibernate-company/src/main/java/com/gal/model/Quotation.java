package com.gal.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int qid;

    private Date qdate;
    private Double cost;
    public Quotation() {
    }

    public Quotation(Date qdate, Double cost) {
        this.qdate = qdate;
        this.cost = cost;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public Date getQdate() {
        return qdate;
    }

    public void setQdate(Date qdate) {
        this.qdate = qdate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Quotation [qid=" + qid +
                ", qdate=" + qdate +
                ", cost=" + cost + "]";
    }
}