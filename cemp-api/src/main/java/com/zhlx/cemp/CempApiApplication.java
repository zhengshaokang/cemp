package com.zhlx.cemp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import tk.mybatis.spring.annotation.MapperScan;

@EnableCaching
@MapperScan(basePackages = "com.zhlx.cemp.mapper")
@SpringBootApplication
public class CempApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CempApiApplication.class, args);
	}
}
