package com.example.busi.inter;

import com.example.pojo.User;

import java.util.List;

public interface IUserBatchService {
    public int insertUsers(List<User> userList);
}
