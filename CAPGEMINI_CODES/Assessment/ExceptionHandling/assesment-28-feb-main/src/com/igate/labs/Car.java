package com.igate.labs;

import java.sql.Date;

public class Car {

    int carid;
    String model;
    String company;
    Date rcDate;
    String carNumber;

    public Car(int carid, String model, String company, Date rcDate, String carNumber) {
        this.carid = carid;
        this.model = model;
        this.company = company;
        this.rcDate = rcDate;
        this.carNumber = carNumber;
    }

    public int getCarid() { return carid; }
    public String getModel() { return model; }
    public String getCompany() { return company; }
    public Date getRcDate() { return rcDate; }
    public String getCarNumber() { return carNumber; }

    @Override
    public String toString() {
        return "Car [carid=" + carid +
                ", model=" + model +
                ", company=" + company +
                ", rcDate=" + rcDate +
                ", carNumber=" + carNumber + "]";
    }
}