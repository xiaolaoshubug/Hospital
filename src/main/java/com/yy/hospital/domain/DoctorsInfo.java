package com.yy.hospital.domain;

public class DoctorsInfo {
    private Integer doid;
    private String doname;
    private String dename;
    private String title;
    private Integer xcum;
    private Integer xcyum;
    private Double bcost;
    private String medcard;

    public DoctorsInfo() {
    }

    public DoctorsInfo(Integer doid, String doname, String dename, String title, Integer xcum, Integer xcyum, Double bcost, String medcard) {
        this.doid = doid;
        this.doname = doname;
        this.dename = dename;
        this.title = title;
        this.xcum = xcum;
        this.xcyum = xcyum;
        this.bcost = bcost;
        this.medcard = medcard;
    }

    public DoctorsInfo(Integer doid, String doname, String dename, String title, Integer xcum, Integer xcyum) {
        this.doid = doid;
        this.doname = doname;
        this.dename = dename;
        this.title = title;
        this.xcum = xcum;
        this.xcyum = xcyum;

    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public String getDoname() {
        return doname;
    }

    public void setDoname(String doname) {
        this.doname = doname;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getXcum() {
        return xcum;
    }

    public void setXcum(Integer xcum) {
        this.xcum = xcum;
    }

    public Integer getXcyum() {
        return xcyum;
    }

    public void setXcyum(Integer xcyum) {
        this.xcyum = xcyum;
    }

    public Double getBcost() {
        return bcost;
    }

    public void setBcost(Double bcost) {
        this.bcost = bcost;
    }

    public String getMedcard() {
        return medcard;
    }

    public void setMedcard(String medcard) {
        this.medcard = medcard;
    }
}
