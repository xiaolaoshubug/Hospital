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
}
