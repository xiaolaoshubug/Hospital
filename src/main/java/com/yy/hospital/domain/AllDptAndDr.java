package com.yy.hospital.domain;

import java.util.List;

public class AllDptAndDr {
    private Integer deid;
    private String dename;
    private String intro;
    private List<Doctors> doctorsList;

    public AllDptAndDr() {
    }

    public AllDptAndDr(Integer deid, String dename, String intro, List<Doctors> doctorsList) {
        this.deid = deid;
        this.dename = dename;
        this.intro = intro;
        this.doctorsList = doctorsList;
    }

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<Doctors> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctors> doctorsList) {
        this.doctorsList = doctorsList;
    }
}
