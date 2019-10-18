package com.example.controller;

import com.example.busi.impl.UserService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    private UserService userService;

    @RequestMapping("print")
    @ResponseBody
    public User print(Long id, String userName, String note) {

        System.out.println("begin print");

        User user = new User();
        user.setNote(note);
        user.setId(id);
        user.setUserName(userName);

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
