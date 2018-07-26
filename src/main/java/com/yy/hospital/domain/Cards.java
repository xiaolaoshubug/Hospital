package com.yy.hospital.domain;

import java.sql.Date;

public class Cards {
    private Integer cid;
    private String pname;
    private String gender;
    private String phone;
    private String idcard;
    private String pwd;
    private Double ramaining;
    private Date newdate;
    private Integer doexist;

    public Cards() {
    }

    public Cards(Integer cid, String pname, String gender, String phone, String idcard, String pwd, Double ramaining, Date newdate, Integer doexist) {
        this.cid = cid;
        this.pname = pname;
        this.gender = gender;
        this.phone = phone;
        this.idcard = idcard;
        this.pwd = pwd;
        this.ramaining = ramaining;
        this.newdate = newdate;
        this.doexist = doexist;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Double getRamaining() {
        return ramaining;
    }

    public void setRamaining(Double ramaining) {
        this.ramaining = ramaining;
    }

    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    public Integer getDoexist() {
        return doexist;
    }

    public void setDoexist(Integer doexist) {
        this.doexist = doexist;
    }
}
