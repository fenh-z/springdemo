package com.example.demo;

import com.example.springaop.HelloService;
import com.example.springaop.HelloServiceImpl;
import com.example.springaop.Myinterceptor;
import com.example.springaop.ProxyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

		HelloService helloService = new HelloServiceImpl();

		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new Myinterceptor());

		proxy.printUser("ssssss");


	}

}
