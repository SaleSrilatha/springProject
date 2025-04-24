package com.jsp.Student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
