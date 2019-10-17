package com.example.demo;

import com.example.springaop.LogAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.example")
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
