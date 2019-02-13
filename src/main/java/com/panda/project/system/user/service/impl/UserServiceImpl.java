package com.panda.project.system.user.service.impl;

import com.panda.common.exception.base.BaseException;
import com.panda.common.exception.user.CaptchaException;
import com.panda.project.system.user.domain.User;
import com.panda.project.system.user.mapper.UserMapper;
import com.panda.project.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jamie
 * @ClassName: UserServiceImpl
 * @Description:
 * @data 2019-01-04 12:10
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {

        List<User> user = userMapper.getAllUser();
        String stringArray[] = {"微学苑", "http://www.weixueyuan.net", "一切编程语言都是纸老虎"};

//        throw new BaseException("1000",stringArray);
        return user;
    }
}
