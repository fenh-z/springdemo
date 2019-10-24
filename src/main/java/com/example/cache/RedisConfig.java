package com.example.cache;

import com.sun.xml.internal.xsom.parser.AnnotationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/22 2:48 下午
 * @Describe
 */
//@Configuration
public class RedisConfig {

    private RedisConnectionFactory connectionFactory;

    @Bean(name = "redisConnectionFactory")
    public RedisConnectionFactory initRedisConnectionFactory() {
        if (this.connectionFactory != null) {
            return connectionFactory;
        }
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(30);//最大空闲数
        poolConfig.setMaxTotal(50);//最大连接数
        poolConfig.setMaxWaitMillis(2000);//最大等待毫秒数

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
        RedisStandaloneConfiguration configuration = jedisConnectionFactory.getStandaloneConfiguration();

        configuration.setHostName("localhost");
        configuration.setPort(6379);

        this.connectionFactory = jedisConnectionFactory;

        return connectionFactory;

    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> initRedisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();

        RedisSerializer stringRedisSerializer = redisTemplate.getStringSerializer();//可直接从reidsTemplate获取

        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);

        redisTemplate.setConnectionFactory(initRedisConnectionFactory());
        return redisTemplate;
    }

    public static void main(String[] args) throws UnknownHostException {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RedisConfig.class);
//        RedisTemplate redisTemplate = (RedisTemplate) applicationContext.getBean("redisTemplate");
//        redisTemplate.opsForValue().set("key1", "1");
//        redisTemplate.opsForHash().put("hash ", "field", "hvalue");


        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress " + addr.getHostAddress());
        String hostname = addr.getHostName();
        System.out.println("Local host name: " + hostname);

    }

}
