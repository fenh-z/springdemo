package com.example.controller;

import com.example.busi.impl.UserBatchService;
import com.example.busi.impl.UserService;
import com.example.busi.inter.IUserBatchService;
import com.example.busi.inter.IUserService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhangdx
 * @Parameter
 * @CreateDate 2019/10/17 11:34 上午
 * @Describe
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IUserBatchService userBatchService;

    @RequestMapping("print")
    @ResponseBody
    public User print(Long id, String userName, String note) {

        System.out.println("begin print");
        System.out.println("begin print");
        System.out.println("begin print");

        User user = new User();
        user.setNote(note);
        user.setId(id);
        user.setUserName(userName);

        System.out.println("end print");
        System.out.println("end print");
        System.out.println("end print");
        System.out.println("end print");
        System.out.println("end print");
        System.out.println("end print");
        System.out.println("end print");
        System.out.println("user print " + user.toString());

        userService.print(user);

        return user;

    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(Long id) {
        return userService.getUser(id);
    }

    @RequestMapping("/insert")
    @ResponseBody
    public Map<String, Object> insertUser(String userName, String note) {
        User user = new User();
        user.setUserName(userName);
        user.setNote(note);

        int update = userService.insertUser(user);

        Map<String, Object> ret = new HashMap<>();
        ret.put("SUCC", update == 1);
        ret.put("USER", user);
        return ret;

    }

    @RequestMapping("/insertUsers")
    @ResponseBody
    public Map<String, Object> inserUsers(String userName0, String note0, String userName1, String note1) {

        User user0 = new User();
        user0.setUserName(userName0);
        user0.setNote(note0);

        User user1 = new User();
        user1.setUserName(userName1);
        user1.setNote(note1);

        List<User> userList = new ArrayList<>();
        userList.add(user0);
        userList.add(user1);

        int iret = userBatchService.insertUsers(userList);

        Map<String, Object> ret = new HashMap<>();
        ret.put("SUCC", iret > 0);
        ret.put("USER", userList);
        return ret;

    }

//    @RequestMapping("vp")
//    @ResponseBody
//    public User validateAndPrint(String id, String userName, String age) {
//        User user = new User();
//        user.setAge(age);
//        user.setId(id);
//        user.setUserName(userName);
//
//        IUserValidate userValidate = (IUserValidate) userService;
//
//        if(userValidate.validate(user)){
//            userService.print(user);
//        }
//
//        return user;
//    }

}
