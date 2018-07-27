package com.yy.hospital.mapper;

import com.yy.hospital.domain.Bookable;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.sql.Date;
import java.util.List;

public interface BookableMapper {

    //查询排班
    @Select("select doid,starttime,bdate from bookable b join  " +
            "(select doid ddoid from doctors where deid = #{deid}) d on b.doid =d.ddoid  " +
            "and  YEARWEEK(bdate,1) = YEARWEEK(#{bdate},1)  " +
            "order BY b.doid asc ,bdate asc;")
    List<Bookable> findBookableByBdateAdDoid(@Param("bdate")Date bdate , @Param("deid")Integer deid);

    //查询上个星期的排班
    @Select("select doid,starttime,bdate,starttime,used,bnum,ynum,xcum,xcyum from bookable b join  " +
            "(select doid ddoid from doctors where deid = #{deid}) d on b.doid =d.ddoid  " +
            "and  YEARWEEK(bdate,1) = YEARWEEK(date_sub(#{bdate},interval 7 day),1)  " +
            "order BY b.doid asc ,bdate asc;")
    List<Bookable> findLastBookable(@Param("bdate")Date bdate , @Param("deid")Integer deid);

    //插入新的排班
    @Insert("insert into bookable (doid,bdate,starttime,used,bnum,xcum) values (#{doid},date_add(#{bdate},interval 7 day),#{starttime},#{used},#{bnum},#{xcum})")
    int insertNewBookable(@Param("doid")Integer doid,@Param("bdate")Date bdate,@Param("starttime")Integer starttime,
                          @Param("used")Integer used,@Param("bnum")Integer bnum,@Param("xcum")Integer xcum);


    //现场可挂号和已挂号数量
    @Select("select xcum,xcyum from bookable where doid = #{doid} and bdate = #{bdate}")
    Bookable findXcumXycum(@Param("doid")Integer doid,@Param("bdate")Date bdate);

    //根据医生和日期查询bid
    @Select("select bid from bookable where doid =  #{doid} and bdate = #{bdate} ")
    Integer findBid(@Param("doid")Integer doid,@Param("bdate")Date bdate);


    //更新现场已预约数量
    @Update("update bookable set xcyum = #{xcyum} + 1 where bid = #{bid}")
    int updateXcyum(@Param("xcyum")Integer xcyum, @Param("bid")Integer bid);


    //根据bid查询排班
    @Select("select * from bookable where bid = #{bid}")
    Bookable findByBid(@Param("bid")Integer bid);

}
