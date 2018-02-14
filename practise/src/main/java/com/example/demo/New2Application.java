package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//@ComponentScan("com.example.demo.bean,com.example.demo.controller,com.example.demo.service")
@SpringBootApplication(scanBasePackages={"com.example.demo.bean.Studentbean","com.example.demo.controller,com.example.demo.service,com.example.demo.domain"})
public class New2Application {

	public static void main(String[] args) {
		SpringApplication.run(New2Application.class, args);
	}
}
