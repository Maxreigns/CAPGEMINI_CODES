package com.gal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "vendor_id")
    private Integer vendorId;

    @Column(name = "vendor_name")
    private String vendorName;

    public Vendor() {
    }

    public Vendor(String vendorName) {
        this.vendorName = vendorName;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    @Override
    public String toString() {
        return vendorId + " " + vendorName;
    }
}