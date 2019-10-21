package com.example.dao.inter;

import com.example.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    public User getUser(Long id);
    public int insertUser(User user);
}
