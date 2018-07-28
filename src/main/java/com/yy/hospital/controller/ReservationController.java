package com.yy.hospital.controller;

import com.yy.hospital.Service.RegistrationService;
import com.yy.hospital.Service.ReservationService;
import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DoctorsInfo;
import com.yy.hospital.domain.ReserPatienBook;
import com.yy.hospital.domain.Reservation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.spi.RegisterableService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/books")
    public ResponseEntity<?> takeReservation(@RequestParam("idcard")String idcard){
        List<ReserPatienBook> reservations = reservationService.findReservation(idcard);
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @RequestMapping(value = "booksviewticket2" , method = RequestMethod.POST)
    public ResponseEntity<?> loadBookList(@RequestParam("red")Integer red,@RequestParam("card")String idcard){

        DoctorsInfo doctorsInfo = reservationService.findAllGram(red);
        Integer deid = doctorsInfo.getDeid();
        Integer snum = (int)registrationService.getToday(deid)+1;
        doctorsInfo.setSnum(snum);

        return new ResponseEntity<>(doctorsInfo,HttpStatus.OK);
    }

}
