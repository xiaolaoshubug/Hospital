package com.yy.hospital.domain;

import java.util.List;

public class WeekBookable {
    private List<String> weekList;
    private List<WeekBean> weekBeanList;

    public WeekBookable() {
    }

    public WeekBookable(List<String> weekList, List<WeekBean> weekBeanList) {
        this.weekList = weekList;
        this.weekBeanList = weekBeanList;
    }

    public List<String> getWeekList() {
        return weekList;
    }

    public void setWeekList(List<String> weekList) {
        this.weekList = weekList;
    }

    public List<WeekBean> getWeekBeanList() {
        return weekBeanList;
    }

    public void setWeekBeanList(List<WeekBean> weekBeanList) {
        this.weekBeanList = weekBeanList;
    }
}
