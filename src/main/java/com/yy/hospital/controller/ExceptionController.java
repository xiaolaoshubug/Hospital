package com.yy.hospital.controller;


import com.yy.hospital.domain.ErrorInfo;
import com.yy.hospital.exception.HospitalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

// 统一的异常类进行处理(把默认的异常返回信息改成自定义的异常返回信息)
// 当GlobalContrller抛出HospitalException异常时，将自动找到此类中对应的方法执行，并返回json数据给前台
@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = HospitalException.class)    //异常处理器，处理HospitalException异常
    public ResponseEntity<?> hanlerException(HttpServletRequest request,HospitalException e){
        ErrorInfo<String> error = new ErrorInfo<>();
        error.setCode(ErrorInfo.ERROR);
        error.setMessage(e.getMessage());
        error.setUrl(request.getRequestURI().toString());
        error.setData("some data");
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
