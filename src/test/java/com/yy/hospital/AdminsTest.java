package com.yy.hospital;


import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Departs;
import com.yy.hospital.domain.Doctors;
import com.yy.hospital.mapper.AdminsMapper;
import com.yy.hospital.mapper.DepartsMapper;
import com.yy.hospital.mapper.RegistrationMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminsTest {

    @Autowired
    private AdminsMapper adminsMapper;  //因为加了MapperScan，没有Repository,所以语法检查的时候出现异常(不用管)
    @Autowired
    private RegistrationMapper registrationMapper;
    @Autowired
    private DepartsMapper departsMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test(){
//        Admins admins = adminsMapper.findByParam("admin","111111");
//        System.out.println(admins.getLoginTime());
//        System.out.println(admins.getAname());

/*        Doctors doctors = adminsMapper.findByDoid(1);
        System.out.println(doctors.getTitle());*/
//        System.out.println(registrationMapper.getToday(4));
        List<Departs>  list = departsMapper.findAll();
        for(int i = 0; i<list.size() ; i++){
            System.out.println(list.get(i).getDename());
        }

    }

    @Test
    public void test1(){
        Admins admins = adminsMapper.findByName("admin");
        System.out.println(admins.getPwd());
    }

    @Test
    public void test2(){
        System.out.println(passwordEncoder.encode("admin"));
    }
}
