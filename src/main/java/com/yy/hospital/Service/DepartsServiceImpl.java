package com.yy.hospital.Service;

import com.yy.hospital.domain.Departs;
import com.yy.hospital.mapper.DepartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("departsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DepartsServiceImpl implements DepartsService{

    @Autowired
    private DepartsMapper departsMapper;


    @Override
    public List<Departs> findList() {
        return departsMapper.find();
    }

    //查找所有部门信息
    @Override
    public List<Departs> findAll() {
        return departsMapper.findAll();
    }

     //插入新的部门
    @Override
    public int insertDeparts(String dename, String intro, Integer deexist) {
        return departsMapper.insertDeparts(dename,intro,deexist);
    }

    @Override
    public int updateDeparts(String dename, String intro, Integer deexist, Integer deid) {
        return departsMapper.updateDeparts(dename,intro,deexist,deid);
    }

    @Override
    public int updateDeexist(Integer deid, Integer deexist) {
        return departsMapper.updateDeexist(deid,deexist);
    }


}
