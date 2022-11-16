package com.dao;


import com.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserDao {

    int insertUser(User user);

    User queryUser(String userName);


}
