package com.jhh.redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtils {
    public static JedisPool jedisPool;
    //在static中读取配置文件并配置redis连接池
    static{
        Properties props = new Properties();
        JedisPoolConfig config = new JedisPoolConfig();
        try {
            String path = "F:\\Vscode\\JavaProject\\J2EE\\redis\\src\\main\\webapp\\WEB-INF\\jedis.properties";
//            InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("F:\\Vscode\\JavaProject\\J2EE\\redis\\src\\main\\webapp\\WEB-INF\\jedis.properties");
            props.load(new FileReader(path));
//            props.load(is);
            config.setMaxTotal(Integer.parseInt(props.getProperty("maxTotal")));
            config.setMaxIdle(Integer.parseInt(props.getProperty("maxIdle")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        jedisPool = new JedisPool(config,props.getProperty("host"),Integer.parseInt(props.getProperty("port")));
    }
    public static Jedis getJedis(){
        return JedisPoolUtils.jedisPool.getResource();
    }
}
