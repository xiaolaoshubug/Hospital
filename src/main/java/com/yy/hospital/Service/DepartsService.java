package com.yy.hospital.Service;

import com.yy.hospital.domain.Departs;

import java.util.List;

public interface DepartsService {

    List<Departs> findList();


    List<Departs> findAll();
}
