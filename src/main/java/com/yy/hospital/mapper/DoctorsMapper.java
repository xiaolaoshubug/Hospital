package com.yy.hospital.mapper;

import com.yy.hospital.domain.Doctors;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@CacheNamespace(implementation = com.yy.hospital.util.RedisCache.class)
public interface DoctorsMapper {
    @Select("select * from doctors where doid=#{doid}")
    Doctors findByDoid(@Param("doid")int doid);
}
