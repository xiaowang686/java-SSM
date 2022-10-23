package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudentByClass(int clazz);

    List<Student> queryStudent(int sCid);

    List<Student> queryStudentByIdAndCourse(int sId);
}
