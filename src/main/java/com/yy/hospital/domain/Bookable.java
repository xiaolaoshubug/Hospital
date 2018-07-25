package com.yy.hospital.domain;

import java.sql.Date;

public class Bookable {
    private Integer bid;
    private Integer doid;
    private Date bdate;
    private Integer starttime;
    private Integer used;
    private Integer bnum;
    private Integer ynum;
    private Integer xcum;
    private Integer xcyum;
    private String by1;
    private Integer by2;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getBnum() {
        return bnum;
    }

    public void setBnum(Integer bnum) {
        this.bnum = bnum;
    }

    public Integer getYnum() {
        return ynum;
    }

    public void setYnum(Integer ynum) {
        this.ynum = ynum;
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
