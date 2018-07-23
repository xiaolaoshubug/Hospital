package com.yy.hospital.mapper;

import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DrAndAdmins;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;

import java.util.List;

@CacheNamespace(implementation = com.yy.hospital.util.RedisCache.class)
public interface DoctorsMapper {
    @Select("select * from doctors where doid=#{doid}")
    Doctors findByDoid(@Param("doid")int doid);

    //查询所有医生
    List<Doctors> findAllDr();

    //更改医生doexist
    @Update("update doctors set doexist = #{doexist} where doid = #{doid} ")
    int updateDrDoexist(@Param("doexist") Integer doexist,@Param("doid") Integer doid);

    //插入一个医生
    Integer insertDr(@Param("doname")String doname,@Param("title")String title, @Param("info")String info,
                 @Param("pcreg")Integer pcreg,@Param("xcreg")Integer xcreg,@Param("bcost")Double bcost,
                 @Param("deid")Integer deid,@Param("doexist")Integer doexist,
                   @Param("monam")Integer monam,@Param("monpm")Integer monpm,
                   @Param("tueam")Integer tueam,@Param("tuepm")Integer tuepm,
                   @Param("wedam")Integer wedam,@Param("wedpm")Integer wedpm,
                   @Param("thuam")Integer thuam,@Param("thupm")Integer thupm,
                   @Param("friam")Integer friam,@Param("fripm")Integer fripm,
                   @Param("satam")Integer satam,@Param("satpm")Integer satpm,
                   @Param("sunam")Integer sumam,@Param("sumpm")Integer sumpm);

    //找到一个医生和用户信息
    DrAndAdmins findOneDrAndPt(@Param("doid")int doid);


    //根据id更改医生信息
    @Update("update doctors set doname=#{doname},title=#{title},info=#{info},pcreg=#{pcreg},xcreg=#{xcreg},bcost=#{bcost}," +
            "monam=#{monam},monpm=#{monpm},tueam=#{tueam},tuepm=#{tuepm},wedam=#{wedam},wedpm=#{wedpm},thuam=#{thuam}," +
            "thupm=#{thupm},friam=#{friam},fripm=#{fripm},satam=#{satam},satpm=#{satpm},sunam=#{sunam},sumpm=#{sumpm} where doid = #{doid}")
    int updateDrById(@Param("doname")String doname,@Param("title")String title, @Param("info")String info,
                     @Param("pcreg")Integer pcreg,@Param("xcreg")Integer xcreg,@Param("bcost")Double bcost,
                     /*@Param("deid")Integer deid,*/
                     @Param("monam")Integer monam,@Param("monpm")Integer monpm,
                     @Param("tueam")Integer tueam,@Param("tuepm")Integer tuepm,
                     @Param("wedam")Integer wedam,@Param("wedpm")Integer wedpm,
                     @Param("thuam")Integer thuam,@Param("thupm")Integer thupm,
                     @Param("friam")Integer friam,@Param("fripm")Integer fripm,
                     @Param("satam")Integer satam,@Param("satpm")Integer satpm,
                     @Param("sunam")Integer sumam,@Param("sumpm")Integer sumpm,
                     @Param("doid")Integer doid);
}
