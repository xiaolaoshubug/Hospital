package com.yy.hospital.mapper;

import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Doctors;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;


//启动类上加了MapperScan，就不用加@Repository
public interface AdminsMapper {


    //根据用户名与密码查询用户信息
    @Select("select * from admins where aexist=1 and aname=#{aname}" +
    " and pwd=#{pwd}")
    Admins findByParam(@Param("aname")String aname,@Param("pwd")String pwd);  //方法原型

    //更新用户密码
    @Update("update admins set pwd=#{pwd} where aname=#{aname}")
    void updatePwd(@Param("pwd")String pwd,@Param("aname")String aname);

    //更新用户的登录的时间
    @Update("update admins set login_time=#{loginTime} where aid=#{aid}")
    void updateLoginTime(@Param("loginTime")Date loginTime,@Param("aid")int aid);



    Admins findByName(@Param("aname")String aname);



}
