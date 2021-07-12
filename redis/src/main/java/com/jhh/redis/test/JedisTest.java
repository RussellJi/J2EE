package com.jhh.redis.test;

import com.jhh.redis.utils.JedisPoolUtils;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

public class JedisTest {
    @Test
    public void test(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("name","jhh");
        jedis.close();
    }
}
