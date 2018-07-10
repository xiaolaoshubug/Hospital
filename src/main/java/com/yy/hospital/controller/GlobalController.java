package com.yy.hospital.controller;

import com.yy.hospital.exception.HospitalException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
//controller层模拟异常的controller
public class GlobalController {
    @RequestMapping("/testError")
    public ResponseEntity<?> testError() throws HospitalException {
        throw new HospitalException("医院自定义异常！");
    }
}
