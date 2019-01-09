package com.xoxo.prjname;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xoxo.prjname.mapper")
public class PrjnameApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjnameApplication.class, args);
	}

}

