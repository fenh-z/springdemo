package com.example.busi.impl;

import com.example.busi.inter.IUserService;
import com.example.dao.inter.UserDao;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/17 11:27 上午
 * @Describe
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void print(User user) {
        if (user == null) {
            throw new RuntimeException("user == null");
        }
        System.out.println("id = " + user.getId());
        System.out.println("name = " + user.getUserName());
    }

    @Override
    @Transactional(timeout = 1)
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional(timeout = 1)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }


}
