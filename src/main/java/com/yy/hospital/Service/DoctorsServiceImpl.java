package com.yy.hospital.Service;


import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DrAndAdmins;
import com.yy.hospital.domain.WeekBean;
import com.yy.hospital.mapper.DoctorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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


/*
    //查询这个星期排班
    @Override
    public List<WeekBean> bookabledepartdoctor(Integer deid, Date date) {
*/
/*        int frontDay =0;
        int lastDay = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E");
        String e = simpleDateFormat.format(date);
        if(e == "星期一"){
            frontDay = 0;
            lastDay = 6;
        }else if(e == "星期二"){
            frontDay = 1;
            lastDay = 5;
        }else if(e == "星期三"){
            frontDay = 2;
            lastDay = 4;
        }else if(e == "星期四"){
            frontDay = 3;
            lastDay = 3;
        }else if(e == "星期五"){
            frontDay = 4;
            lastDay = 2;
        }else if(e == "星期六"){
            frontDay = 5;
            lastDay = 1;
        }else if(e == "星期日"){
            frontDay = 6;
            lastDay = 0;
        }*//*


        return doctorsMapper.bookabledepartdoctor(deid,date);
    }
*/




}
