package com.dao;

import com.pojo.Student;
import com.utils.MybatisUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest extends TestCase {

    public void testSelectStudentByClassTest() {
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        List<Student> list = studentDao.selectStudentByClass(1);
        for (Student student: list){
            System.out.println(student);
        }
    }

    @Test
    public void testQueryStudent() {
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        List<Student> student = studentDao.queryStudent(1);
        for (Student student1:student){
            System.out.println(student1);
        }
    }

    @Test
    public void testQueryStudentByIdAndCourseTest() {
        StudentDao studentDao = MybatisUtil.getMapper(StudentDao.class);
        List<Student> studentList = studentDao.queryStudentByIdAndCourse(1);
        for (Student student:studentList){
            System.out.println(student);
        }
    }

}