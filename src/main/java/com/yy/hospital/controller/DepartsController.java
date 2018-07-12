package com.yy.hospital.controller;

import com.yy.hospital.Service.DepartsService;
import com.yy.hospital.domain.Departs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DepartsController {
    @Autowired
    private DepartsService departsService;


    //科室管理--科室列表：展现科室列表
    @RequestMapping(value = "/departs",method = RequestMethod.GET)
    public List<Departs> displayAllDeparts(){
        List<Departs> list = new ArrayList<>();
        list = departsService.findAll();
        return list;
    }


    //科室管理--科室列表：添加科室
    @RequestMapping(value = "/departs",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Integer>> insertDeparts(@RequestBody Departs departs){
        Map<String,Integer> map = new HashMap<>();
        int result = 0;
        result = departsService.insertDeparts(departs.getDename(),departs.getIntro(),departs.getDeexist());
        map.put("result",result);
        return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);

    }

    //科室管理--科室列表：修改科室
    @RequestMapping(value = "/departs",method = RequestMethod.PUT)
    public ResponseEntity<Map<String,Integer>> updateDeparts(@RequestBody Departs departs){
        Map<String,Integer> map = new HashMap<>();
        int result = 0;
        result = departsService.updateDeparts(departs.getDename(),departs.getIntro(),departs.getDeexist(),departs.getDeid());
        map.put("result",result);
        return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);

    }

    //科室管理--科室列表：停用启用科室
    @RequestMapping(value = "/departschangestate",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Integer>> departschangestate(@RequestParam("deid")Integer deid,@RequestParam("deexist")Integer deexist){
        Map<String,Integer> map = new HashMap<>();
        int result = 0;
        result = departsService.updateDeexist(deid,deexist);
        map.put("result",result);
        return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }
}
