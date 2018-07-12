package com.yy.hospital;

import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Departs;
import com.yy.hospital.mapper.AdminsMapper;
import com.yy.hospital.mapper.DepartsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Autowired
    private DepartsMapper departsMapper;
    @Autowired
    private AdminsMapper adminsMapper;

    @Test
    public void test1(){
        List<Departs> list1 = departsMapper.find();
        System.out.println("第一次："+list1.size());
        List<Departs> list2 = departsMapper.find();
        System.out.println("第二次："+list2.size());
        List<Departs> list3 = departsMapper.find();
        System.out.println("第二次："+list3.size());

/*        Admins admins = adminsMapper.findByName("admin");
        System.out.println("第一次查");
        Admins admins2 = adminsMapper.findByName("admin");
        System.out.println("第二次查");*/

    }

    @Test
    public void test2(){
        List<Admins> list1 = adminsMapper.findByState(1);
        System.out.println("第一次查");
        List<Admins> list2 = adminsMapper.findByState(1);
        System.out.println("第二次查");


    }
}
