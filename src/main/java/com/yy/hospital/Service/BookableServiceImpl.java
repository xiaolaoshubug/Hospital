package com.yy.hospital.Service;

import com.yy.hospital.domain.Bookable;
import com.yy.hospital.mapper.BookableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("bookService")
public class BookableServiceImpl implements BookableService{

    @Autowired
    private BookableMapper bookableMapper;

    @Override
    public List<Bookable> findBookableByBdateAdDoid(Date bdate, Integer deid) {
        return bookableMapper.findBookableByBdateAdDoid(bdate , deid);
    }

    @Override
    public List<Bookable> findLastBookable(Date bdate, Integer deid) {
        return bookableMapper.findLastBookable(bdate , deid);
    }

    @Override
    public int insertNewBookable(Integer doid, Date bdate, Integer starttime, Integer used, Integer bnum, Integer xcum) {
        return bookableMapper.insertNewBookable(doid,bdate,starttime,used,bnum,xcum);
    }
}
