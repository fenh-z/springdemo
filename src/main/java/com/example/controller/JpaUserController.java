package com.example.controller;

import com.example.jpa.inter.JpaUserRepository;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/18 2:30 下午
 * @Describe
 */
@Controller
@RequestMapping("/jpausr")
public class JpaUserController {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        User user = jpaUserRepository.findById(id).get();
        return user;
    }

}
