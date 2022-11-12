package com;

import com.dao.UserDao;
import com.pojo.Student;
import com.pojo.User;
import com.proxy.BookDao;
import com.proxy.BookDaoImpl;
import com.proxy.TxManager;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        User zhangsan = userDao.queryUser("zhangsan");
        System.out.println(zhangsan);
    }
}
