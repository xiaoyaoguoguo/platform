package com.panda.common.utils.auth;

import com.panda.common.utils.SessionUtils;
import com.panda.common.utils.cookie.CookieUtils;
import com.panda.common.utils.redis.RedisUtil;
import com.panda.common.utils.spring.SpringUtils;
import com.panda.framework.domain.UserDto;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpSession;

/**
 * @author jamie
 * @ClassName: AuthUtils
 * @Description: 授权工具类
 * @data 2019-01-07 17:14
 **/
public class AuthUtils {

    private static final String USER = "current_user";
    private static final String CID = "cid";

    private static final Long EXP_TIME = 1800L;


    public AuthUtils() {
        super();
    }

    public static void setUser(UserDto user) {
        setUser(user, false);
    }

    private static void setUser(UserDto user, boolean remember) {
        HttpSession session = SessionUtils.getSession();
        session.setAttribute(USER, user);
        String cid = CookieUtils.get(CID);
        if (StringUtils.isBlank(cid)) {
            cid = SessionUtils.getSession().getId();
            System.out.println(cid);
            CookieUtils.setSid(CID, cid);
        }
        RedisUtil redisUtil = SpringUtils.getBean("redisUtil");
        redisUtil.set(cid, user, EXP_TIME);
    }

    public static UserDto getUser() {
        UserDto userDto = (UserDto) SessionUtils.getSession().getAttribute(USER);
        if (userDto == null) {
            RedisUtil redisUtil = SpringUtils.getBean("redisUtil");
            String cid = CookieUtils.get(CID);
            if (!StringUtils.isBlank(cid)) {
                userDto = (UserDto) redisUtil.get(cid);
            }
        }
        return userDto;
    }


}
