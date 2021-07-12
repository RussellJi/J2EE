package com.jhh.dao;

import com.jhh.domain.User;

public class UserDao extends BasicDao<User>{
    public User login(String username,String password){
        String sql = "select * from user where username = ? and password = ?";
        return querySingle(sql,User.class,username,password);
    }
}
