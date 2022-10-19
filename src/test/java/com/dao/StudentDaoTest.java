package com.dao;

import com.pojo.Student;
import com.utils.MybatisUtil;
import junit.framework.TestCase;

import java.util.List;

public class StudentDaoTest extends TestCase {

    public void testSelectStudentByClassTest() {
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        List<Student> list = studentDao.selectStudentByClass(1);
        for (Student student: list){
            System.out.println(student);
        }
    }
}