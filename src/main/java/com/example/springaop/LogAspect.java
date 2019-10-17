package com.example.springaop;

import com.example.busi.impl.UserValidate;
import com.example.busi.inter.IUserValidate;
import com.example.pojo.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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

//    @DeclareParents(value = "com.example.busi.impl.UserService+", defaultImpl = UserValidate.class)
//    public IUserValidate userValidate;

    @Pointcut("execution(* com.example.busi.impl.UserService.print(..))")
    public void pointCut() {

    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("around before");
        joinPoint.proceed();
        System.out.println("around after");

    }

    @Before("pointCut()")
    public void doBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if(args !=null) {
            System.out.println("args = " + args.toString());
        }
        System.out.println("this is before");
    }

    @After("pointCut()")
    public void doAfter() {
        System.out.println("this is after");
    }

}
