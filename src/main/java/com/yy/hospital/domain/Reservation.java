package com.yy.hospital.domain;

import org.springframework.web.bind.annotation.PathVariable;

public class Reservation {
    private Integer red;
    private Patients patients;
    private Bookable bookable;
    private Integer state;
    private String by1;
    private Integer by2;
    private Double bcost;

    public Reservation() {
    }

    public Reservation(Integer red, Patients patients, Bookable bookable, Integer state, String by1, Integer by2, Double bcost) {
        this.red = red;
        this.patients = patients;
        this.bookable = bookable;
        this.state = state;
        this.by1 = by1;
        this.by2 = by2;
        this.bcost = bcost;
    }

    public Double getBcost() {
        return bcost;
    }

    public void setBcost(Double bcost) {
        this.bcost = bcost;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Bookable getBookable() {
        return bookable;
    }

    public void setBookable(Bookable bookable) {
        this.bookable = bookable;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public Integer getBy2() {
        return by2;
    }

    public void setBy2(Integer by2) {
        this.by2 = by2;
    }
}
