package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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
        mapOps.put("key5", "val5");

        return out;
    }

    //list操作
    @RequestMapping("/list")
    @ResponseBody
    public Map<String, Object> list() {

        stringRedisTemplate.opsForList().leftPushAll("list1", "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForList().rightPushAll("list2", "v1", "v2", "v3", "v4", "v5", "v6");

        BoundListOperations list2 = stringRedisTemplate.boundListOps("list2");

        list2.rightPop();//从右边弹出一个成员

        String ret = (String) list2.index(1);//按照index去除一个

        log.info("@@@@@@@@@  ret = {}", ret);

        list2.leftPush("v133");
        list2.leftPush("v111", "v333");

        List<String> elements = list2.range(0, list2.size() - 2);

        for (String element : elements) {
            log.info("@@@@  element = {}", element);
        }


        return new HashMap<>();
    }

    @RequestMapping("/set")
    @ResponseBody
    public Map<String, Object> set() {

        stringRedisTemplate.opsForSet().add("set1", "v1", "v2", "v3", "v4");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v3", "v4", "v5", "v6");

        BoundSetOperations set1 = stringRedisTemplate.boundSetOps("set1");

        set1.add("v7", "v8");
        set1.remove("v1");

        Set<String> set1cp = set1.members();

        set1cp.forEach(settmp -> {
            log.info("@@@@@ settmp = {}", settmp);
        });

        //求交集
        Set inter = set1.intersect("set2");

        inter.forEach(intertmp -> {
            log.info("@@@@@@ intertmp = {}", intertmp);
        });

        //求差集
        Set diff = set1.diff("set2");

        diff.forEach(difftmp -> {
            log.info("@@@@@@ difftmp = {}", difftmp);
        });

        //求并集
        Set union = set1.union("set2");

        union.forEach(unionTmp -> {
            log.info("@@@@@@ unionTmp = {}", unionTmp);
        });

        //求并集 并用新的集合保存
        set1.unionAndStore("set1", "union");

        return new HashMap<>();
    }


    @RequestMapping("/zset")
    @ResponseBody
    public Map<String, Object> zset() {

        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            // 分数
            double score = i * 0.1;
            // 创建一个TypedTuple对象，存入值和分数
            ZSetOperations.TypedTuple<String> typedTuple = new DefaultTypedTuple<>("value" + i, score);
            typedTupleSet.add(typedTuple);
        }

        stringRedisTemplate.opsForZSet().add("zset1", typedTupleSet);

        BoundZSetOperations zsetOps = stringRedisTemplate.boundZSetOps("zset1");

        zsetOps.add("value10", 0.26);

        Set<String> setRange = zsetOps.range(0, 6);

        setRange.forEach(setTmp -> log.info("@@@@@@ setTmp = {}", setTmp));

        Set<String> setScore = zsetOps.rangeByScore(0.2, 0.6);//通过score排序获取有序集合

        setScore.forEach(setTmp -> log.info("@@@@@@ setScoreTmp = {}", setTmp));

        return new HashMap<>();
    }

    @RequestMapping("/multi")
    @ResponseBody
    public Map<String, Object> multi() {

        redisTemplate.opsForValue().set("keyn", "value1");



        return new HashMap<>();
    }

}
