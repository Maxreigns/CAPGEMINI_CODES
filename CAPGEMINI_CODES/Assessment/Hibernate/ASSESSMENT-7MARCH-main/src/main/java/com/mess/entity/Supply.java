package com.mess.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "supply")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "sid")
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "itemid")
    private Item item;

    public Supply() {}

    public Supply(Supplier supplier, Item item) {
        this.supplier = supplier;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}