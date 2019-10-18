package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories(basePackages = "com.example.jpa")
@EntityScan(basePackages = "com.example.pojo")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

//		HelloService helloService = new HelloServiceImpl();
//
//		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new Myinterceptor());
//
//		proxy.printUser("ssssss");


    }

}
