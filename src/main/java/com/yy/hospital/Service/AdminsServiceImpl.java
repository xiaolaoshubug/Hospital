package com.yy.hospital.Service;

import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Doctors;
import com.yy.hospital.mapper.AdminsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("adminsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class AdminsServiceImpl implements AdminsService {
    @Autowired
    private AdminsMapper adminsMapper;

    //增删改要加事务处理
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Admins login(String aname, String pwd) {
        return adminsMapper.findByParam(aname,pwd);
    }

    @Override
    public void logout(Date loginTime, int aid) {
        adminsMapper.updateLoginTime(loginTime,aid);
    }

    @Override
    public void resetPassword(String pwd, String aname) {
        adminsMapper.updatePwd(pwd,aname);
    }


}
