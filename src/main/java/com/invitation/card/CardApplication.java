package com.invitation.card;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.invitation.card.controller","com.invitation.card.service","com.invitation.card.aspect","com.invitation.card.handle"})
@MapperScan(basePackages = "com.invitation.card.mapper")  //配置mapper扫描
@SpringBootApplication
public class CardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardApplication.class, args);
	}
}
