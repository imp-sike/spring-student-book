package com.sugar.sms.service;

import java.util.List;

import com.sugar.sms.entity.Student;

public interface StudentService {
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student updatSetudent(Student student);

    Student getStudentById(Long id);

    void deleteStudent(Long id);
}
