package com.excel.springjdbc.dao;

import com.excel.springjdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, student.getName(), student.getAge());
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Student.class));
    }

    @Override
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
}
