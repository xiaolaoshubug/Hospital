package com.yy.hospital.mapper;

import com.yy.hospital.domain.Doctors;
import com.yy.hospital.domain.DoctorsInfo;
import com.yy.hospital.domain.ReserPatienBook;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ReservationMapper {

    List<ReserPatienBook> findReservation(@Param("idcard")String idcard);

    DoctorsInfo findAllGram(@Param("red")Integer red);

    @Update("update reservation set state = 1 where red = #{red}")
    int updateState(@Param("red")Integer red);
}
