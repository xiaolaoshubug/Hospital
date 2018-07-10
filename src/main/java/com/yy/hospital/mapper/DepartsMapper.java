package com.yy.hospital.mapper;

import com.yy.hospital.domain.Departs;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

public interface DepartsMapper {

    //查询所有没被禁用的科室信息
    @Select("select * from departs where deexist=1")
    List<Departs> find();

    //查询所有的科室信息
    @Select("select deid,dename,intro,deexist from departs")
    List<Departs> findAll();
}
