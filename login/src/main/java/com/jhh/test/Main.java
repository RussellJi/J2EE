package com.jhh.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhh.dao.UserDao;
import com.jhh.domain.User;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class Main {
    
    @Test
    public void test(){
        String username = "jhh";
        String password = "123456";
        UserDao userDao = new UserDao();
        String pass = (String)userDao.queryScalar("select password from user where username= ?", User.class, username);
        System.out.println(pass);
        if(pass.equals(password)){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码不正确");
        }

    }
    @Test
    public void test1(){
        User user = new User("纪浩瀚","12345");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileWriter("F://a.txt"),user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test2(){
        String str = "{\"username\":\"纪浩瀚\",\"password\":\"123456\"}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            User user = mapper.readValue(str,User.class);
            System.out.println(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
