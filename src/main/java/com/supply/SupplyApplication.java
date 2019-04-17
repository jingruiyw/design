package com.supply;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.book.mall.mall.mapper")
@SpringBootApplication
public class SupplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplyApplication.class, args);
	}

}
