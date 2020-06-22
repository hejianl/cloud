package com.kkhjl.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.kkhjl.cloud.member.dao")
public class MemberStartApplication {
	public static void main(String[] args) {
		SpringApplication.run(MemberStartApplication.class, args);
	}
}
