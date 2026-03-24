package com.igate.labs;

import java.util.List;

public class Owner {

    int ownerid;
    String name;
    String gender;
    List<Car> cars;

    public Owner(int ownerid, String name, String gender, List<Car> cars) {
        this.ownerid = ownerid;
        this.name = name;
        this.gender = gender;
        this.cars = cars;
    }

    public int getOwnerid() { return ownerid; }
    public String getName() { return name; }
    public String getGender() { return gender; }
    public List<Car> getCars() { return cars; }

    @Override
    public String toString() {
        return "Owner [ownerid=" + ownerid +
                ", name=" + name +
                ", gender=" + gender +
                ", cars=" + cars + "]";
    }
}