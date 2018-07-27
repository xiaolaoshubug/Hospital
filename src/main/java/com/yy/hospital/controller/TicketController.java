package com.yy.hospital.controller;

import com.yy.hospital.Service.*;
import com.yy.hospital.domain.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private DepartsService departsService;
    @Autowired
    private DoctorsService doctorsService;
    @Autowired
    private BookableService bookableService;
    @Autowired
    private CardsService cardsService;
    @Autowired
    private RegistrationService registrationService;


    @RequestMapping(value = "/booksbuyticket" , method = RequestMethod.GET)
    public ResponseEntity<List<AllDptAndDr>> downnetBuyTicket(){
        List<AllDptAndDr> list = new ArrayList<>();
        //获得所有的可用科室编号
        List<Departs> departList = departsService.findList();

        for(int n=0 ; n<departList.size() ; n++){
            AllDptAndDr allDptAndDr = new AllDptAndDr();
            //属性doctorsList
            List<Doctors> doctorsList =doctorsService.findDrByDeidBdate(departList.get(n).getDeid(),new Date(System.currentTimeMillis()));

            allDptAndDr.setDoctorsList(doctorsList);
            //属性Deid
            allDptAndDr.setDeid(departList.get(n).getDeid());
            //属性Dename
            allDptAndDr.setDename(departList.get(n).getDename());
            //属性Intro
            allDptAndDr.setIntro(departList.get(n).getIntro());
            list.add(allDptAndDr);
        }
        //封装AllDptAndDr

        return new ResponseEntity<List<AllDptAndDr>>(list , HttpStatus.OK);
    }

    @RequestMapping(value = "/booksbuyticketdoctor" , method = RequestMethod.POST)
    public ResponseEntity<?> findDrByDeidBdateDoid(@RequestParam("doid")Integer doid){
        DoctorsInfo doctorsInfo = doctorsService.findDrByDeidBdateDoid(new Date(System.currentTimeMillis()),doid);
        return new ResponseEntity<DoctorsInfo>(doctorsInfo , HttpStatus.OK);
    }

    @RequestMapping(value = "/bookscheckmedcard" , method = RequestMethod.POST)
    public ResponseEntity<?> selectByIdcard(@RequestBody DoctorsInfo doctorsInfo){
        int result = -1 ;
        Cards cards = cardsService.selectByIdcard(doctorsInfo.getMedcard());
        if( !cards.equals(null)){
            result = 1;
        }
        //生成票号(获取今天该科室的挂号人数)
        System.out.println("-1-1-1-1-1-1-1-1-1    "+doctorsService.findOneDrAndPt(doctorsInfo.getDoid()).getDeid());  //test
        Integer snum = (int)(registrationService.getToday(doctorsService.findOneDrAndPt(doctorsInfo.getDoid()).getDeid()))+1;
        System.out.println("0000000000-------"+snum);   //test
        Map<String,Object> map = new HashMap<>();
        map.put("result",result);
        map.put("snum",snum);
        map.put("pname",cards.getPname());
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);

    }


    @RequestMapping(value = "/booksgetticket" , method = RequestMethod.POST)
    public ResponseEntity<?> getRegistration(@RequestBody RegistrationInfo registrationInfo){
        HashMap map = new HashMap();

        if(registrationInfo.getStarttime() == 1){
            if((double)registrationInfo.getBcost() > (double)cardsService.selectByIdcard(registrationInfo.getMedcard()).getRamaining()){
                map.put("result",-1);
                return new ResponseEntity<Map>(map,HttpStatus.OK);
            }else{
                //扣除诊疗卡的钱
                cardsService.cutRamaining( (double)registrationInfo.getBcost(),registrationInfo.getMedcard());
            }
        }
        //生成一个挂号单
        //诊疗卡id--cid
        Integer cid = cardsService.selectByIdcard(registrationInfo.getMedcard()).getCid();
        //排班表id--bid
        Integer doid = doctorsService.findDoid(registrationInfo.getDoname());
        Integer bid = bookableService.findBid(doid,new Date(System.currentTimeMillis()));
        //票号
        Integer snum = registrationInfo.getSnum();

        //是否已就诊
        Integer state = 0;
        int result = registrationService.insertNewRegst(cid,bid,snum,state);

        //更新医生今天的已经就诊人数（bookable）
        Integer xcyum = bookableService.findByBid(bid).getXcyum();
        bookableService.updateXcyum(xcyum,bid);
        map.put("result",1);
        return new ResponseEntity<>(map,HttpStatus.OK);


    }
}
