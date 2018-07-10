package com.yy.hospital.security.service;

import com.yy.hospital.domain.Admins;
import com.yy.hospital.mapper.AdminsMapper;
import com.yy.hospital.security.domain.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminsMapper adminsMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admins user = adminsMapper.findByName(username);
        if(user==null){
            throw new UsernameNotFoundException("用户名不存在！");
        }else{
            return JwtUserFactory.create(user);
        }
    }
}
