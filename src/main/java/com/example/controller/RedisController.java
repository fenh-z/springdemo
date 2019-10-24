package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/24 9:51 上午
 * @Describe
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    private static final Logger log = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> stringAndHash() {

        log.info("@@@@@@@@  string and hash @@@@@@@@@");

        Map<String, Object> out = new HashMap<>();

        log.info("begin put");
        redisTemplate.opsForValue().set("int_key", "1");
        log.info("end put");

        stringRedisTemplate.opsForValue().set("int", "1");

        Map<String, Object> map = new HashMap<>();

        map.put("key0", "val0");
        map.put("key1", "val1");
        map.put("key2", "val2");

        stringRedisTemplate.opsForHash().putAll("hash", map);

        stringRedisTemplate.opsForHash().put("hash", "key3", "val3");

        BoundHashOperations mapOps = stringRedisTemplate.boundHashOps("hash");
        mapOps.delete("key1");
        mapOps.put("key5","val5");

        return out;
    }

}
