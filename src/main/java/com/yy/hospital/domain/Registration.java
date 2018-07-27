package com.yy.hospital.domain;

public class Registration {
    private Integer rid;
    private Integer cid;
    private Bookable bookable;
    private Integer snum;
    private Integer state;
    private String by1;
    private Integer by2;



    public Registration(Integer rid, Integer cid, Bookable bookable, Integer snum, Integer state, String by1, Integer by2) {
        this.rid = rid;
        this.cid = cid;
        this.bookable = bookable;
        this.snum = snum;
        this.state = state;
        this.by1 = by1;
        this.by2 = by2;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Bookable getBookable() {
        return bookable;
    }

    public void setBookable(Bookable bookable) {
        this.bookable = bookable;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
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
