package com.yy.hospital.domain;

import java.sql.Date;

public class ReserPatienBook {
    private Integer red;
    private String pname;
    private String phone;
    private String dename;
    private String doname;
    private Date bdate;
    private Double bcost;
    private Integer medcard;

    public ReserPatienBook() {
    }

    public ReserPatienBook(Integer red, String pname, String phone, String dename, String doname, Date bdate, Double bcost, Integer medcard) {
        this.red = red;
        this.pname = pname;
        this.phone = phone;
        this.dename = dename;
        this.doname = doname;
        this.bdate = bdate;
        this.bcost = bcost;
        this.medcard = medcard;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getDoname() {
        return doname;
    }

    public void setDoname(String doname) {
        this.doname = doname;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Double getBcost() {
        return bcost;
    }

    public void setBcost(Double bcost) {
        this.bcost = bcost;
    }

    public Integer getMedcard() {
        return medcard;
    }

    public void setMedcard(Integer medcard) {
        this.medcard = medcard;
    }
}
