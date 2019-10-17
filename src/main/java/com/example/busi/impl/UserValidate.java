package com.example.busi.impl;

import com.example.busi.inter.IUserValidate;
import com.example.pojo.User;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/17 3:38 下午
 * @Describe
 */
public class UserValidate implements IUserValidate {
    @Override
    public boolean validate(User user) {
        System.out.println("引入的接口 " + UserValidate.class.getSimpleName());
        return user != null;
    }
}
