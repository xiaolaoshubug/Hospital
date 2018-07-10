package com.yy.hospital;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.yy.hospital.mapper") //MapperScan指定mapper接口的基础包//不用再每个mapper下写@Repository注解了
/*@EnableCaching    //允许缓存配置
@EnableRedisHttpSession   //允许Redis缓存session*/
public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
}
