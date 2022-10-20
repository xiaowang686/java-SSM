package com.dao;

import com.pojo.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudentByClass(int clazz);

}
