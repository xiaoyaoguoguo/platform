package com.panda.project.system.user.service.impl;

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

        return userMapper.getAllUser();
    }
}
