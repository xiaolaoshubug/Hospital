package com.yy.hospital.domain;

public class Patients {
    private Integer pid;
    private String pname;
    private String gender;
    private String phone;
    private String idcard;
    private String pwd;
    private Integer medcard;
    private String emaii;
    private String by1;
    private Integer by2;


    public Patients() {
    }

    public Patients(Integer pid, String pname, String gender, String phone, String idcard, String pwd, Integer medcard, String emaii, String by1, Integer by2) {
        this.pid = pid;
        this.pname = pname;
        this.gender = gender;
        this.phone = phone;
        this.idcard = idcard;
        this.pwd = pwd;
        this.medcard = medcard;
        this.emaii = emaii;
        this.by1 = by1;
        this.by2 = by2;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Integer getMedcard() {
        return medcard;
    }

    public void setMedcard(Integer medcard) {
        this.medcard = medcard;
    }

    public String getEmaii() {
        return emaii;
    }

    public void setEmaii(String emaii) {
        this.emaii = emaii;
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
