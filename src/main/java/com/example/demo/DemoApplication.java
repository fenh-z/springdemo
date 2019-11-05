package com.example.demo;

import com.example.redis.RedisMsgListener;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;
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

    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisMsgListener redisMsgListener;

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    public void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
    }


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

//		HelloService helloService = new HelloServiceImpl();
//
//		HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new Myinterceptor());
//
//		proxy.printUser("ssssss");


    }

}
