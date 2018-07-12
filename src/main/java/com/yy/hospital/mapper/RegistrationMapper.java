package com.yy.hospital.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

@CacheNamespace(implementation = com.yy.hospital.util.RedisCache.class)
public interface RegistrationMapper  {



    //查询某科室今天的挂号数量
    @Select("SELECT count(rid) from registration r" +
            "  join bookable b ON r.bid=b.bid" +
            "  join doctors d on b.doid=d.doid" +
            "  JOIN departs de on d.deid=de.deid" +
            "  WHERE de.deid=#{deid} and to_days(bdate) = to_days(now())")
    int getToday(@Param("deid")Integer deid);

    //查询某科室昨天的挂号数量
    @Select("SELECT count(rid) from registration r" +
            "  join bookable b ON r.bid=b.bid" +
            "  join doctors d on b.doid=d.doid" +
            "  JOIN departs de on d.deid=de.deid" +
            "  WHERE de.deid=#{deid} and to_days(now()) - to_days(bdate) = 1")
    int getYestoday(@Param("deid")Integer deid);

    //查询某科室本周的挂号数量
    @Select("SELECT count(rid) from registration r" +
            "  join bookable b ON r.bid=b.bid" +
            "  join doctors d on b.doid=d.doid" +
            "  JOIN departs de on d.deid=de.deid" +
            "  WHERE de.deid=#{deid} and YEARWEEK(date_format(bdate,'%Y-%m-%d')) = YEARWEEK(now())")
    int getWeek(@Param("deid")Integer deid);

    //查询某科室本月挂号数量
    @Select("SELECT count(rid) from registration r" +
            "  join bookable b ON r.bid=b.bid" +
            "  join doctors d on b.doid=d.doid" +
            "  JOIN departs de on d.deid=de.deid" +
            "  WHERE de.deid=#{deid} and date_format(bdate,'%Y%m') = date_format(curdate(),'%Y%m')")
    int  getMonth(@Param("deid")Integer deid);

    //查询某科室本季度挂号数量
    @Select("SELECT count(rid) from registration r" +
            "  join bookable b ON r.bid=b.bid" +
            "  join doctors d on b.doid=d.doid" +
            "  JOIN departs de on d.deid=de.deid" +
            "  WHERE de.deid=#{deid} and QUARTER(bdate)=QUARTER(now())")
    int getQuarter(@Param("deid")Integer deid);
}
