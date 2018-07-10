package com.yy.hospital.controller;

import com.yy.hospital.Service.AdminsService;
import com.yy.hospital.Service.DoctorsService;
import com.yy.hospital.domain.Admins;
import com.yy.hospital.domain.Doctors;
import com.yy.hospital.mapper.DoctorsMapper;
import com.yy.hospital.security.JwtTokenUtil;
import com.yy.hospital.security.domain.JwtUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:8080",maxAge = 3600)
@RequestMapping("/api")
public class AdminsController {
    @Autowired
    private AdminsService adminsService;

    @Autowired
    private DoctorsService doctorsService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    @Qualifier("jwtUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;
/*
    //修改密码
    @Deprecated
    @RequestMapping(value="/changepwd",method = RequestMethod.PUT)
    public ResponseEntity<?> resetPasswrod(@RequestParam("pwd")String pwd,@RequestParam("password")String password,@RequestParam("password2")String password2,HttpSession session){
        Admins admin = (Admins) session.getAttribute("user");
        //先判断原始密码是否正确
        if(!pwd.equals(admin.getPwd())){
            return new ResponseEntity<CustomerErrorType>(new CustomerErrorType("原始密码输入错误！"),HttpStatus.OK);
        }

        //更新密码
        String aname = admin.getAname();
        adminsService.resetPassword(password,aname);
        //根据新密码查询用户
        admin = adminsService.login(aname,password);
        if(admin == null){
            //因为现在是redis存session了，改了密码后，要重新更新redis里面的user
            session.setAttribute("user",admin);
            return new ResponseEntity<CustomerErrorType>(new CustomerErrorType("密码重设不成功！"),HttpStatus.OK);
        }else{
            return new ResponseEntity<Admins>(admin,HttpStatus.OK);
        }
    }

*/

    //修改密码
    @RequestMapping(value = "/changepwd",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> resetPasswrod(HttpServletRequest request,@RequestParam("password")String password,@RequestParam("password2")String password2){

        String authToken = request.getHeader(tokenHeader);
        final String token = authToken.substring(7);
        password = passwordEncoder.encode(password);
        String username = jwtTokenUtil.getUsernameFromToken(token);

        adminsService.resetPassword(password,username);
        //根据新密码查询用户
        Admins admin = adminsService.login(username,password);
        if(admin == null){
            return new ResponseEntity<CustomerErrorType>(new CustomerErrorType("密码重设不成功！"),HttpStatus.OK);
        }else{
            JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
            return new ResponseEntity<JwtUser>(user,HttpStatus.OK);
        }
    }















}
