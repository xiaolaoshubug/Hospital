package com.yy.hospital.Service;

import com.yy.hospital.domain.Bookable;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;

import java.sql.Date;
import java.util.List;

public interface BookableService {
    List<Bookable> findBookableByBdateAdDoid(Date bdate , Integer deid);

    List<Bookable> findLastBookable(Date bdate , Integer deid);

    int insertNewBookable(Integer doid,Date bdate,Integer starttime,
                          Integer used,Integer bnum,Integer xcum);


    Bookable findXcumXycum(Integer doid,Date bdate);

    Integer findBid(Integer doid, Date bdate);

    //更新现场已预约数量
    int updateXcyum(Integer xcyum,Integer bid);

    Bookable findByBid(Integer bid);
}
