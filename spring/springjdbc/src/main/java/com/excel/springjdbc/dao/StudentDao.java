package com.excel.springjdbc.dao;

import com.excel.springjdbc.entities.Student;

import java.util.List;

public interface StudentDao {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void deleteStudent(int id);
}
