package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.example")
//@EnableJpaRepositories(basePackages = "com.example.jpa")
//@EntityScan(basePackages = "com.example.pojo")
@MapperScan(
        //指定扫描包
        basePackages = "com.example.dao.inter",
        annotationClass = Repository.class
)
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
