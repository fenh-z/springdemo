package com.example.springaop;

import java.lang.reflect.InvocationTargetException;

/**
 * com.example.springaop
 *
 * @author zhangdongxiao
 * @create 2019-08-26 17:30
 * @desc
 */

public class Myinterceptor implements Interceptor {
    @Override
    public boolean before() {
        System.out.println("before ........");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after .....");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ........");
        Object obj = invocation.proceed();
        System.out.println("around after .....");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println(" afterReturning ..... ");
    }

    @Override
    public void afterThrowing() {
        System.out.println(" afterThrowing ...... ");
    }

    @Override
    public boolean userAround() {
        return true;
    }
}
