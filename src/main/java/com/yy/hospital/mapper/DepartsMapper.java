package com.yy.hospital.mapper;

import com.yy.hospital.domain.Departs;
import org.apache.ibatis.annotations.*;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@CacheNamespace(implementation = com.yy.hospital.util.RedisCache.class)
public interface DepartsMapper {

    //查询所有没被禁用的科室信息
    @Select("select * from departs where deexist=1")
    List<Departs> find();

    //查询所有的科室信息
    @Select("select deid,dename,intro,deexist from departs")
    List<Departs> findAll();


    //添加科室
    @Insert("insert into departs (dename,intro,deexist) values (#{dename},#{intro},#{deexist}) ")
    int insertDeparts(@Param("dename")String dename,@Param("intro")String intro,@Param("deexist")Integer deexist);

    //更新科室
    @Update("update departs set dename=#{dename},intro=#{intro},deexist=#{deexist} where deid=#{deid}")
    int updateDeparts(@Param("dename")String dename,@Param("intro")String intro,@Param("deexist")Integer deexist,@Param("deid")Integer deid);

    //更改科室deexist
    @Update("update departs set deexist=#{deexist} where deid=#{deid}")
    int updateDeexist(@Param("deid")Integer deid,@Param("deexist")Integer deexist);
}
