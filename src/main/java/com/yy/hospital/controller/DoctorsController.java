package com.yy.hospital.controller;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import com.yy.hospital.Service.AdminsService;
import com.yy.hospital.Service.DoctorsService;
import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DrAndAdmins;
import com.yy.hospital.domain.WeekBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DoctorsController {

    @Autowired
    private DoctorsService doctorsService;
    @Autowired
    private AdminsService adminsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/doctors" , method = RequestMethod.GET)
    public ResponseEntity<List<Doctors>> findAllDr(){
        List<Doctors> list = new ArrayList<>();
        list = doctorsService.findAllDr();
        return  new ResponseEntity<List<Doctors>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/doctors/{doid:\\d+}" , method = RequestMethod.GET)
    public ResponseEntity<DrAndAdmins> findOneDr(@PathVariable("doid")int doid ){
        DrAndAdmins drAndAdmins = new DrAndAdmins();
        drAndAdmins = doctorsService.findOneDrAndPt(doid);
        return  new ResponseEntity<DrAndAdmins>(drAndAdmins, HttpStatus.OK);
    }


    @RequestMapping(value = "/doctorschangestate",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String,Integer>> doctorschangestate(@RequestParam("doexist")Integer doexist,@RequestParam("doid")Integer doid){
        Map<String,Integer> map = new HashMap<>();
        int result = 0;
        result = doctorsService.updateDrDoexist(doexist,doid);
        map.put("result",result);
        return  new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }

     //新增医生和用户信息
    @RequestMapping(value = "/doctors",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String,Integer>> insertDr(@RequestBody DrAndAdmins drAndAdmins){

        Map<String,Integer> map = new HashMap<>();
        int result = 1;

        result = doctorsService.insertDr(drAndAdmins.getDoname(),drAndAdmins.getTitle(),drAndAdmins.getInfo(),drAndAdmins.getPcreg(),drAndAdmins.getXcreg(),Double.valueOf(drAndAdmins.getBcost()),drAndAdmins.getDeid(),
                1,drAndAdmins.getMonam(),drAndAdmins.getMonpm(),drAndAdmins.getTueam(),drAndAdmins.getTuepm(),drAndAdmins.getWedam(),drAndAdmins.getWedpm(),drAndAdmins.getThuam(),drAndAdmins.getThupm(),
                drAndAdmins.getFriam(),drAndAdmins.getFripm(),drAndAdmins.getSatam(),drAndAdmins.getSatpm(),drAndAdmins.getSunam(),drAndAdmins.getSumpm());
        result += adminsService.insertAdminsReDoid(drAndAdmins.getAname(),passwordEncoder.encode(drAndAdmins.getPwd()));
        map.put("result",result==2?1:0);
        return  new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }

    //更改医生用户信息
    @RequestMapping(value="/doctors",method = RequestMethod.PUT)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String,Integer>> updateDrById(@RequestBody Doctors doctors/*@RequestParam("doname")String doname*/){

        Map<String,Integer> map = new HashMap<>();
        int result ;

        result = doctorsService.updateDrById(doctors);
        map.put("result",result);
        return  new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }

}
