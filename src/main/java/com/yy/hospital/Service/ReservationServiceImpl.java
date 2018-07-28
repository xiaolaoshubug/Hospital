package com.yy.hospital.Service;

import com.yy.hospital.domain.DoctorsInfo;
import com.yy.hospital.domain.ReserPatienBook;
import com.yy.hospital.domain.Reservation;
import com.yy.hospital.mapper.ReservationMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reservationService")
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    private ReservationMapper reservationMapper;


    @Override
    public List<ReserPatienBook> findReservation(String idcard) {
        return reservationMapper.findReservation(idcard);
    }

    @Override
    public DoctorsInfo findAllGram(Integer red) {
        return reservationMapper.findAllGram(red);
    }

    @Override
    public int updateState(Integer red) {
        return reservationMapper.updateState(red);
    }


}
