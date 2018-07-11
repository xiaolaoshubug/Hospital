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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    //修改密码
    @RequestMapping(value = "/changepwd",method = RequestMethod.POST)
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> resetPasswrod(HttpServletRequest request,@RequestParam("password")String password,@RequestParam("password2")String password2){

        String authToken = request.getHeader(tokenHeader);
        /*final*/ String token = authToken.substring(7);
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






    @RequestMapping(value = "/admins/{state}",method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findByState(@PathVariable("state")Integer state){
        List<Admins> list=adminsService.findByState(state);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @RequestMapping(value = "/admins",method = RequestMethod.POST)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addAdmins(@RequestBody Admins admins){
        admins.setState(1);
        admins.setPwd(passwordEncoder.encode(admins.getPwd()));
        int result=adminsService.addGeneralAdmins(admins);
        Map<String,Object> map=new HashMap<>();
        map.put("result",result);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }





}
