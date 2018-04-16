package com.nyeong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nyeong.mapper")
public class NyeongjinApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyeongjinApplication.class, args);
	}
}
