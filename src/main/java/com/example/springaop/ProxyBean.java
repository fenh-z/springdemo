package com.example.springaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * com.example.springaop
 *
 * @author zhangdongxiao
 * @create 2019-08-26 17:34
 * @desc
 */

public class ProxyBean implements InvocationHandler {

    private Object target = null;
    private Interceptor interceptor = null;

    public static Object getProxyBean(Object obj, Interceptor interceptor) {

        ProxyBean proxyBean = new ProxyBean();

        proxyBean.target = obj;
        proxyBean.interceptor = interceptor;

        Object proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        boolean exceptionFlag = false;

        Invocation invocation = new Invocation(target, method, args);

        Object retObj = null;

        try {
            if (this.interceptor.before()) {
                retObj = this.interceptor.around(invocation);
            } else {
                retObj = method.invoke(target, args);
            }

        } catch (Exception e) {
            exceptionFlag = true;
            e.printStackTrace();
        }

        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else {
            this.interceptor.afterReturning();
        }

        return retObj;
    }
}
