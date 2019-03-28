package com.mini.program;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mini.program.dao")
public class BackServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(BackServerApplication.class, args);
	}
}
