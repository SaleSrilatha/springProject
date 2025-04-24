package com.jsp.Student.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.jsp.Student.entity.Student;
import com.jsp.Student.repo.StudentRepo;




@Repository
public class StudentCrud {

	@Autowired
	StudentRepo repo;
	
	public Student save(Student student) {
		return repo.save(student);
	}
	
	public Optional<Student> getStudentById(int id) {
       return repo.findById(id);
   }
	
	public List<Student> getAllStudents() {
        return repo.findAll();
    }
	
	public void deleteStudent(int id) {
        repo.deleteById(id);
    }
	
	public Student updateStudent(Student newStudent, int id) {
	    Optional<Student> optionalStudent = repo.findById(id);
	    if (optionalStudent.isPresent()) {
	        Student student = optionalStudent.get();
	        student.setName(newStudent.getName());
	        student.setEmail(newStudent.getEmail());
	        student.setPwd(newStudent.getPwd());
	        student.setMarks(newStudent.getMarks());
	        return repo.save(student);
	    } else {
	        return null; // Or throw an exception, depending on your application's requirement
	    }
	}
	
	
	public Student fetchById(int id) {
		Optional<Student> db = repo.findById(id);
		
		if(db.isPresent()) {
			return db.get();
		}else {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
