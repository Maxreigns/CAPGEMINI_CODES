package com.gal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "itemid")
    private Integer itemId;

    @Column(name = "itemtype")
    private String itemType;

    @Column(name = "itemname")
    private String itemName;

    @Column(name = "cost")
    private double cost;
    
    public Item() {}

    public Item(String itemType, String itemName, double cost) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.cost = cost;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return itemId + " " + itemType + " " + itemName + " " + cost;
    }
}