package com.yy.hospital.domain;

public class DoctorsInfo {
    private Integer doid;
    private String doname;
    private String dename;
    private String title;
    private Integer xcum;
    private Integer xcyum;
    private Double bcost;
    private Integer medcard;
    private Integer deid;
    private String pname;
    private Integer snum;


    public DoctorsInfo() {
    }

    public DoctorsInfo(Integer doid, String doname, String dename, String title, Integer xcum, Integer xcyum, Double bcost, Integer medcard, Integer deid, String pname, Integer snum) {
        this.doid = doid;
        this.doname = doname;
        this.dename = dename;
        this.title = title;
        this.xcum = xcum;
        this.xcyum = xcyum;
        this.bcost = bcost;
        this.medcard = medcard;
        this.deid = deid;
        this.pname = pname;
        this.snum = snum;
    }

    public void setMedcard(Integer medcard) {
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

    public Integer getMedcard() {
        return medcard;
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

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }
}
