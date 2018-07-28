package com.yy.hospital.domain;

public class RegistrationInfo {
    private Integer snum;//票号
    private String pname; //就诊人
    private String doname; //医生
    private String dename; //科室
    private Integer bcost; //挂号费
    private Integer medcard; //诊疗卡
    private Integer starttime; //1为诊疗卡，0为现金
    private Integer red;


    public RegistrationInfo() {
    }

    public RegistrationInfo(Integer snum, String pname, String doname, String dename, Integer bcost, Integer medcard, Integer starttime, Integer red) {
        this.snum = snum;
        this.pname = pname;
        this.doname = doname;
        this.dename = dename;
        this.bcost = bcost;
        this.medcard = medcard;
        this.starttime = starttime;
        this.red = red;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
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

    public Integer getBcost() {
        return bcost;
    }

    public void setBcost(Integer bcost) {
        this.bcost = bcost;
    }

    public Integer getMedcard() {
        return medcard;
    }

    public void setMedcard(Integer medcard) {
        this.medcard = medcard;
    }

    public Integer getStarttime() {
        return starttime;
    }

    public void setStarttime(Integer starttime) {
        this.starttime = starttime;
    }

}
