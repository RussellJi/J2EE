package com.jhh.test;

import com.jhh.dao.UserDao;
import com.jhh.domain.User;
import org.junit.Test;

import java.util.List;

public class Main {
    
    @Test
    public void test(){
        String username = "jhh";
        String password = "123456";
        UserDao userDao = new UserDao();
        String pass = (String)userDao.queryScalar("select password from user where username= ?", User.class, "jhh");
        System.out.println(pass);
        if(pass.equals(password)){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码不正确");
        }

    }

}
