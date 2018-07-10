package com.yy.hospital.controller;

import com.yy.hospital.Service.DepartsService;
import com.yy.hospital.domain.Departs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartsController {
    @Autowired
    private DepartsService departsService;

    @RequestMapping(value = "/departs",method = RequestMethod.GET)
    public List<Departs> displayAllDeparts(){
        List<Departs> list = new ArrayList<>();
        list = departsService.findAll();

        for(int i = 0; i<list.size() ; i++){
            System.out.println(list.get(i).getDename());
        }
        return list;
    }
}
