package com.yy.hospital.Service;

import com.yy.hospital.domain.Doctors;
import com.yy.hospital.mapper.DoctorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("doctorsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DoctorsServiceImpl implements DoctorsService{

    @Autowired
    private DoctorsMapper doctorsMapper;
    @Override
    public Doctors getDoctorsTitle(int doid) {
        return doctorsMapper.findByDoid(doid);
    }
}
