package com.example.pojo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * com.example.pojo
 *
 * @author zhangdongxiao
 * @create 2019-08-19 11:47
 * @desc
 */

@Component
public class BussinessPerson implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean,
        DisposableBean {


    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + "调用 BeanFactoryAware 的 setBeanFactory ”");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println(this.getClass().getSimpleName() + "调用 BeanNameAware 的 setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " DisposableBean 方法");
    }

    @PreDestroy
    public void destroy0() throws Exception {
        System.out.println(this.getClass().getSimpleName() + " 注解g Pre Destroy 定义的自定义销毁方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(this.getClass().getSimpleName() + "调用 InitializingBean的 afterPropertiesSet 方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + "调用 ApplicationContextAware 的 setAppl 工 cationContext");
    }
}