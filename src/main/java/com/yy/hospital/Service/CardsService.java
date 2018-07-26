package com.yy.hospital.Service;


import com.yy.hospital.domain.Cards;

import java.sql.Date;
import java.util.List;

public interface CardsService {

    //查找所有的卡
    List<Cards> findAllCards();

    //更改doexist
    int updateDoexist(Integer doexist,Integer cid);

    //注册新卡
    int insertNewCard(String pname, String gender, String phone, String idcard, Date newdate);

    //充值
    int updateRamaining(Double money,Integer cid);

}
