package com.yy.hospital.controller;

import com.yy.hospital.Service.CardsService;
import com.yy.hospital.domain.Cards;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class CardsController {
    @Autowired
    private CardsService cardsService;

    @RequestMapping(value = "/cards" , method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> findAllCards(){
        List<Cards> list = cardsService.findAllCards();
        return new ResponseEntity<List<Cards>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/cards/{cid}/0/enable" , method = RequestMethod.PUT)
    public ResponseEntity<?> doexistToZero(@PathVariable("cid")Integer cid){

        cardsService.updateDoexist(0,cid);
        return new ResponseEntity<String>("Ok",HttpStatus.OK);
    }

    @RequestMapping(value = "/cards/{cid}/1/enable" , method = RequestMethod.PUT)
    public ResponseEntity<?> doexistToOne(@PathVariable("cid")Integer cid){

        cardsService.updateDoexist(1,cid);
        return new ResponseEntity<String>("Ok",HttpStatus.OK);
    }

    @RequestMapping(value="/cards" , method = RequestMethod.POST)
    public ResponseEntity<?> insertNewCard(@RequestBody Cards cards){
        Map<String,Integer> map = new HashMap<>();
        int result = cardsService.insertNewCard(cards.getPname(),cards.getGender(),cards.getPhone(),cards.getIdcard(),new Date(System.currentTimeMillis()));
        map.put("result",result);
        return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }

    @RequestMapping(value="/cards/{cid}/{val}/topup",method = RequestMethod.PUT)
    public ResponseEntity<?> updateRamaining(@PathVariable("cid")Integer cid,@PathVariable("val")Double val){
        Map<String,Integer> map = new HashMap<>();
        int result = 0;
        if(val<0){
            map.put("result",result);
            return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
        }
        result = cardsService.updateRamaining(val,cid);
        map.put("result",result);
        return new ResponseEntity<Map<String,Integer>>(map,HttpStatus.OK);
    }
}
