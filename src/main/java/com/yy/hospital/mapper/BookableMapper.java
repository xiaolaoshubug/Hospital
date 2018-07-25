package com.yy.hospital.mapper;

import com.yy.hospital.domain.Bookable;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Date;
import java.util.List;

public interface BookableMapper {

    //查询
    @Select("select doid,starttime,bdate from bookable b join  " +
            "(select doid ddoid from doctors where deid = #{deid}) d on b.doid =d.ddoid  " +
            "and  YEARWEEK(bdate,1) = YEARWEEK(#{bdate},1)  " +
            "order BY b.doid asc ,bdate asc;")
    List<Bookable> findBookableByBdateAdDoid(@Param("bdate")Date bdate , @Param("deid")Integer deid);
}
