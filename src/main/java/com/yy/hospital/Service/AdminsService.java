package com.yy.hospital.Service;

import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Doctors;

import java.util.Date;

public interface AdminsService {
    //用户登录
    Admins login(String aname,String pwd);

    //用户注销
    void logout(Date loginTime,int aid);

    //更新密码
    void resetPassword(String pwd,String aname);


}
