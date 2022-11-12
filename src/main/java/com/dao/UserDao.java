package com.dao;


import com.pojo.User;

public interface UserDao {

    int insertUser(User user);

    User queryUser(String userName);


}
