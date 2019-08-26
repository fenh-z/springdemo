package com.example.springaop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * com.example.springaop
 *
 * @author zhangdongxiao
 * @create 2019-08-26 17:25
 * @desc
 */

public class Invocation {

    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object[] params, Method method, Object target) {
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target, params);
    }

}
