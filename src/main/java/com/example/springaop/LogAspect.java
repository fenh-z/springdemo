package com.example.springaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/16 4:53 下午
 * @Describe
 */
@Aspect
@Configuration
public class LogAspect {

    @Pointcut("execution(* com.example.busi.impl.UserService.print(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void doBefore() {
        System.out.println("this is before");
    }

    @After("pointCut()")
    public void doAfter() {
        System.out.println("this is after");
    }

}
