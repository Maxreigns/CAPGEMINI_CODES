package com.cms.gal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "quotation")
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    // Many quotations -> one project
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Quotation() {}

    public Quotation(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    // Getters & Setters
    public void setProject(Project project) {
        this.project = project;
    }
}