package com.book.mall.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan(value = "com.book.mall.mall.mapper")
@SpringBootApplication
public class MallApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MallApplication.class, args);
	}

	//为了打包springboot项目
	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}


}
