package com.yy.hospital.domain;

import java.io.Serializable;
import java.util.List;

public class DepartBooks implements Serializable{

    private List<String> times;  //时间段的名称集合--表头的今天，昨天，本周，本月，本季度
    private List<BooksDepartCounts>  booksDepartCounts;   //所有科室对应挂号人数集合

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }

    public List<BooksDepartCounts> getBooksDepartCounts() {
        return booksDepartCounts;
    }

    public void setBooksDepartCounts(List<BooksDepartCounts> booksDepartCounts) {
        this.booksDepartCounts = booksDepartCounts;
    }
}
