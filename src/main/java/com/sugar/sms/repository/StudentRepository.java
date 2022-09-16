package com.sugar.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sugar.sms.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Long>{}
