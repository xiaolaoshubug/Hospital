package com.yy.hospital.Service;

import com.yy.hospital.domain.Departs;

import java.util.List;

public interface DepartsService {

    List<Departs> findList();

    List<Departs> findAll();

    int insertDeparts(String dename,String intro,Integer deexist);

    int updateDeparts(String dename,String intro,Integer deexist,Integer deid);

    int updateDeexist(Integer deid,Integer deexist);
}
