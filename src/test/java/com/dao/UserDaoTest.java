package com.dao;

import com.pojo.Details;
import com.pojo.User;
import com.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void insertUserTest() {

        User user = new User(0,"zhangsan","123456","李四","01.jpg");
        Details details = new Details(0,"广东深圳","17755554444","个性签名",0);
        //插入User和Details信息，并提交手动事务
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            UserDao userDao = MybatisUtil.getMapper(UserDao.class);
            userDao.insertUser(user);
            details.setUserId(user.getUserId());

            DetailsDao detailsDao = MybatisUtil.getMapper(DetailsDao.class);
            detailsDao.insertDeatils(details);

            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }



    }

    @Test
    public void queryUserTest(){
        UserDao userDao = MybatisUtil.getMapper(UserDao.class);
        User user = userDao.queryUser("zhangsan");
        System.out.println(user);
    }
}