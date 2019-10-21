package com.example.busi.impl;

import com.example.busi.inter.IUserBatchService;
import com.example.dao.inter.UserDao;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/21 3:49 下午
 * @Describe
 */
@Service
public class UserBatchService implements IUserBatchService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public int insertUsers(List<User> userList) {

        int cnt = 0;

        for (User user : userList) {
            cnt += userDao.insertUser(user);
        }

        return cnt;
    }
}
