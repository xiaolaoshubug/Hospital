package com.yy.hospital.Service;

import com.yy.hospital.domain.DoctorsInfo;
import com.yy.hospital.domain.ReserPatienBook;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ReservationService {

   List<ReserPatienBook> findReservation(String idcard);

   DoctorsInfo findAllGram(Integer red);


   int updateState(Integer red);
}
