package com.example.busi.impl;

import com.example.busi.inter.IUserService;
import com.example.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/17 11:27 上午
 * @Describe
 */
@Service
public class UserService implements IUserService {
    @Override
    public void print(User user) {
        if (user == null) {
            throw new RuntimeException("user == null");
        }
        System.out.println("id = " + user.getId());
        System.out.println("name = " + user.getUserName());
    }
}
