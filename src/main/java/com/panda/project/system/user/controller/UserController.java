package com.panda.project.system.user.controller;

import com.github.pagehelper.PageInfo;
import com.panda.common.utils.auth.AuthUtils;
import com.panda.framework.domain.JsonReturn;
import com.panda.framework.domain.UserDto;
import com.panda.project.system.user.domain.User;
import com.panda.project.system.user.service.UserService;
import com.panda.framework.aspectj.lang.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @PostMapping("/login")
    @ResponseBody
    public JsonReturn login(){
        UserDto userDto = new UserDto();
        userDto.setUserId(UUID.randomUUID().toString());
        AuthUtils.setUser(userDto);
        return new JsonReturn();
    }
    @PostMapping("/userInfo")
    @ResponseBody
    @Auth(isAuth = true)
    public JsonReturn userInfo(){

        return new JsonReturn(AuthUtils.getUser());
    }


}
