package com;

import com.dao.UserDao;
import com.pojo.Student;
import com.pojo.User;
import com.proxy.BookDao;
import com.proxy.BookDaoImpl;
import com.proxy.TxManager;
import com.service.Impl.UserServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userDao = (UserServiceImpl) context.getBean("userServiceImpl");
        User zhangsan = userDao.queryUser("zhangsan");
        System.out.println(zhangsan);
    }
}
