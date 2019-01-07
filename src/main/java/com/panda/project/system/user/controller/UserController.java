package com.panda.project.system.user.controller;

import com.github.pagehelper.PageInfo;
import com.panda.project.system.user.domain.User;
import com.panda.project.system.user.service.UserService;
import com.panda.framework.aspectj.lang.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jamie
 * @ClassName: UserController
 * @Description:
 * @data 2019-01-04 12:01
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    @Auth(isAuth = true)
    @ResponseBody
    public PageInfo<User> getAllUser(){

//        PageHelper.startPage(1, 2);
        List<User> userList = userService.getAllUser();

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }



}
