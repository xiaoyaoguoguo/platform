package com.panda;

import com.panda.common.utils.MessageUtils;
import com.panda.common.utils.SessionUtils;
import com.panda.common.utils.redis.RedisDao;
import com.panda.common.utils.redis.RedisUtil;
import com.panda.common.utils.spring.SpringUtils;
import com.panda.framework.domain.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformApplicationTests {
    @Autowired
    private RedisDao redisUtil;

    @Test
    public void contextLoads() {
//        redisUtil.set("123","你好啊啊",20);
//
//
//        UserDto o = (UserDto)redisUtil.get("E680A6C48882912E2F4B96C6E3FE3F0B");
//        System.out.println(o.toString());


        String message = MessageUtils.message("test", "");
        System.out.println(message);


    }

}

