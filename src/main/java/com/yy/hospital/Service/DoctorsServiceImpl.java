package com.yy.hospital.Service;

import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DrAndAdmins;
import com.yy.hospital.mapper.DoctorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("doctorsService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class DoctorsServiceImpl implements DoctorsService{

    @Autowired
    private DoctorsMapper doctorsMapper;
    @Override
    public Doctors getDoctorsTitle(int doid) {
        return doctorsMapper.findByDoid(doid);
    }

    @Override
    public List<Doctors> findAllDr() {
        return doctorsMapper.findAllDr();
    }

    @Override
    public int updateDrDoexist(Integer doexist, Integer doid) {
        return doctorsMapper.updateDrDoexist(doexist,doid);
    }

    @Override
    public int insertDr(String doname, String title, String info, Integer pcreg, Integer xcreg, Double bcost, Integer deid, Integer doexist, Integer monam, Integer monpm, Integer tueam, Integer tuepm, Integer wedam, Integer wedpm, Integer thuam, Integer thupm, Integer friam, Integer fripm, Integer satam, Integer satpm, Integer sumam, Integer sumpm) {
        return doctorsMapper.insertDr(doname,title,info, pcreg,xcreg,bcost, deid,doexist,
                monam, monpm, tueam, tuepm, wedam, wedpm, thuam, thupm, friam,fripm, satam,  satpm, sumam,  sumpm);
    }

    @Override
    public DrAndAdmins findOneDrAndPt(Integer doid) {
        return doctorsMapper.findOneDrAndPt(doid);
    }

    @Override
    public int updateDrById(Doctors doctors) {
        return doctorsMapper.updateDrById(doctors.getDoname(),doctors.getTitle(),doctors.getInfo(),
                                            doctors.getPcreg(),doctors.getXcreg(),Double.valueOf(doctors.getBcost()),
                                            /*doctors.getDeid(),*/
                                            doctors.getMonam(),doctors.getMonpam(),
                                            doctors.getTueam(),doctors.getTuepm(),
                                            doctors.getWedam(),doctors.getWedpm(),
                                            doctors.getThuam(),doctors.getThupm(),
                                            doctors.getFriam(),doctors.getFripm(),
                                            doctors.getSatam(),doctors.getSatpm(),
                                            doctors.getSunam(),doctors.getSunpm(),doctors.getDoid());
    }


}
