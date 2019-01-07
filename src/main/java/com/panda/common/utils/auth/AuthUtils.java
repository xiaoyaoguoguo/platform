package com.panda.common.utils.auth;

import com.panda.framework.domain.UserDto;

/**
 * @author jamie
 * @ClassName: AuthUtils
 * @Description: 授权工具类
 * @data 2019-01-07 17:14
 **/
public class AuthUtils {

    private static final String USER = "current_user";

    public AuthUtils() {
        super();
    }

    public static void setUser(UserDto user){
        setUser(user,false);
    }

    private static void setUser(UserDto user, boolean remember) {

    }


}
