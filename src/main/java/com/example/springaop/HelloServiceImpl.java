package com.example.springaop;

import com.example.pojo.User;

/**
 * com.example.springaop
 *
 * @author zhangdongxiao
 * @create 2019-08-26 16:58
 * @desc
 */

public class HelloServiceImpl implements HelloService {

    @Override
    public void printUser(String name) {
        System.out.println("Hello " + name);
        System.out.println("Hello " + name);
        System.out.println("Hello " + name);
    }
}
