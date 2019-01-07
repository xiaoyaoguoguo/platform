package com.panda;

import com.panda.common.utils.redis.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformApplicationTests {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        redisUtil.set("123","你好啊啊",20);


        Object o = redisUtil.get("123");
        System.out.println(o);
    }

}

