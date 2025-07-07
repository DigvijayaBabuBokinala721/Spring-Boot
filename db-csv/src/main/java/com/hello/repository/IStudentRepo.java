package com.hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hello.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
