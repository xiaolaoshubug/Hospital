package com.yy.hospital.mapper;

import com.yy.hospital.domain.Cards;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.omg.CORBA.INTERNAL;

import javax.annotation.ParametersAreNonnullByDefault;
import java.sql.Date;
import java.util.List;

public interface CardsMapper {

    //查找所有卡
    @Select("select cid,pname,gender,phone,idcard,pwd,ramaining,newdate,doexist from cards")
    public List<Cards> findAllCard();

    //更改卡的可用性
    @Update("update cards set doexist = #{doexist} where cid = #{cid}")
    public Integer updateDoexist(@Param("doexist")Integer doexist, @Param("cid")Integer cid);

    //注册一张新卡,默认密码888888
    @Insert("insert into cards (pname,gender,phone,idcard,pwd,ramaining,newdate,doexist) values (#{pname},#{gender},#{phone},#{idcard},'888888',100.0,#{newdate},1)")
    public int insertNewCard(@Param("pname")String pname, @Param("gender")String gender, @Param("phone")String phone, @Param("idcard")String idcard, @Param("newdate")Date newdate);

    //充值
    @Update("update cards set ramaining= ramaining + #{money}  where cid = #{cid}")
    public int updateRamaining(@Param("money")Double money,@Param("cid")Integer cid);
}
