package com.panda.project.system.user.controller;

import com.github.pagehelper.PageInfo;
import com.panda.common.utils.auth.AuthUtils;
import com.panda.framework.domain.JsonReturn;
import com.panda.framework.domain.UserDto;
import com.panda.framework.web.controller.BaseController;
import com.panda.framework.web.page.TableDataInfo;
import com.panda.project.system.user.domain.User;
import com.panda.project.system.user.service.UserService;
import com.panda.framework.aspectj.lang.annotation.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * @author jamie
 * @ClassName: UserController
 * @Description:
 * @data 2019-01-04 12:01
 **/
@RestController
public class UserController extends BaseController {
    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    @Auth(isAuth = true)
    @ResponseBody
    public TableDataInfo getAllUser(HttpServletResponse response) {
        startPage();
        List<User> userList = userService.getAllUser();
        response.setHeader("token","1231348635");
//        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return getDataTable(userList);
//        return pageInfo;
    }

    @PostMapping("/login")
    @ResponseBody
    public JsonReturn login() {
        UserDto userDto = new UserDto();
        userDto.setUserId(UUID.randomUUID().toString());
        AuthUtils.setUser(userDto);
        return new JsonReturn();
    }

    @PostMapping("/userInfo")
    @ResponseBody
    @Auth(isAuth = true)
    public JsonReturn userInfo() {
        return new JsonReturn(AuthUtils.getUser());
    }

    @GetMapping("/logout")
    @ResponseBody
    public JsonReturn logout() {
        AuthUtils.removeUser();
        return new JsonReturn();
    }


}
