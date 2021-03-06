package com.yy.hospital.Service;

import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Doctors;

import java.util.Date;
import java.util.List;

public interface AdminsService {
    //用户登录
    Admins login(String aname,String pwd);

    //用户注销
    void logout(Date loginTime,int aid);

    //更新密码
    void resetPassword(String pwd,String aname);

    //查找管理员
    List<Admins> findByState(Integer state);

    //增加一个普通管理员
    int addGeneralAdmins(Admins admins);

    //更改用户的状态
    int updateUserAexist(Integer aid,Integer aexist);

    //插入一个医生用户
    int insertAdminsReDoid(String aname,String pwd);

}
