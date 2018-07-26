package com.yy.hospital.Service;

import com.yy.hospital.domain.Cards;
import com.yy.hospital.mapper.CardsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;

@Service("cardsService")
public class CardsServiceImpl implements CardsService {

    @Autowired
    private CardsMapper cardsMapper;

    @Override
    public List<Cards> findAllCards() {
        return cardsMapper.findAllCard();
    }

    @Override
    public int updateDoexist(Integer doexist, Integer cid) {
        return cardsMapper.updateDoexist(doexist,cid);
    }

    @Override
    public int insertNewCard(String pname, String gender, String phone, String idcard, Date newdate) {
        return cardsMapper.insertNewCard(pname,gender,phone,idcard,newdate);
    }

    @Override
    public int updateRamaining(Double money, Integer cid) {
        return cardsMapper.updateRamaining(money,cid);
    }
}
