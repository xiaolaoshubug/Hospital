package com.yy.hospital.Service;


import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DrAndAdmins;
import com.yy.hospital.domain.WeekBean;


import java.sql.Date;
import java.util.List;

public interface DoctorsService {
    //获取医生title
    Doctors getDoctorsTitle(int doid);

    //获取所有医生列表
    List<Doctors> findAllDr();



    //更改医生doexist
    int updateDrDoexist(Integer doexist,Integer doid);

    //插入医生
    int insertDr(String doname, String title,String info,
                 Integer pcreg,Integer xcreg, Double bcost,
                 Integer deid, Integer doexist,
                 Integer monam, Integer monpm,
                 Integer tueam, Integer tuepm,
                 Integer wedam, Integer wedpm,
                 Integer thuam, Integer thupm,
                 Integer friam, Integer fripm,
                 Integer satam, Integer satpm,
                 Integer sumam, Integer sumpm);

    //找到一个医生和用户信息
    DrAndAdmins findOneDrAndPt(Integer doid);

    //根据id更改医生信息
    int updateDrById(Doctors doctors);


}
