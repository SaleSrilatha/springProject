package com.jsp.Student.service;

import java.io.File;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.Student.dao.StudentCrud;
import com.jsp.Student.dto.StudentEmail;
import com.jsp.Student.entity.Student;
import com.jsp.Student.exception.StudentIdNotFound;
import com.jsp.Student.util.ResourceStructure;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class StudentService {

	@Autowired
	private StudentCrud crud;
	
	@Autowired
	private JavaMailSender emailSender;
	
	
	public  void sendMsg(StudentEmail student) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("salesrilatha15@gmail.com");
		message.setTo(student.getTo());
		message.setSubject(student.getSubject());
		message.setText(student.getBody());
		
		emailSender.send(message);
	}
	
	public  void sendOtp(StudentEmail student) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom("salesrilatha15@gmail.com");
		message.setTo(student.getTo());
		message.setSubject(student.getSubject());
		
		Random random=new Random();
		int otp=random.nextInt(900000);
		
		message.setText("OTP Verification \n"+"enter the otp as"+otp);
		
		emailSender.send(message);
	}
	
	
	public void sendAttachment(StudentEmail student) throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("salesrilatha15@gmail.com");
		helper.setTo(student.getTo());
		helper.setSubject(student.getSubject());
		helper.setText(student.getBody());
		
		FileSystemResource file = new FileSystemResource(new File("C:\\Users\\srilatha\\Pictures\\Saved Pictures\\olaf.jpg"));
		helper.addAttachment("image.jpg", file);
		emailSender.send(message);	
	}
	

	public ResponseEntity<ResourceStructure<StudentEmail>>save(StudentEmail student){
		StudentEmail db=new StudentEmail("salesrilatha15@gmail.com", "hello", "olaf", "C:\\Users\\srilathas\\Pictures\\Saved Pictures\\olaf.jpg");
		
		ResourceStructure<StudentEmail>rs=new ResourceStructure<StudentEmail>();
		rs.setData(db);
		rs.setMessage("Student data saved successfully.");
		rs.setStatus(HttpStatus.CREATED.value());
		return new ResponseEntity<ResourceStructure<StudentEmail>>(rs,HttpStatus.CREATED) ;
		
	}	
	
	
	public ResponseEntity<ResourceStructure<Student>> saveStudent(Student student) {
        Student savedStudent = crud.save(student);
        ResourceStructure<Student> rs = new ResourceStructure<>();
        rs.setData(savedStudent);
        rs.setMessage("Student data saved successfully.");
        rs.setStatus(HttpStatus.CREATED.value());
        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }
	
	public void deleteStudent(int id) {
        crud.deleteStudent(id);
    }
	

	
	public ResponseEntity<ResourceStructure<Student>> fetchStudent(int id) {
        Student savedStudent = crud.fetchById(id);
        if(savedStudent!=null) {
        
        ResourceStructure<Student> rs = new ResourceStructure<>();
        rs.setData(savedStudent);
        rs.setMessage("Student found successfully...");
        rs.setStatus(HttpStatus.FOUND.value());
        return new ResponseEntity<ResourceStructure<Student>>(rs, HttpStatus.FOUND);
        }else {

        	throw new StudentIdNotFound("student id"+"not found of your given id please check the id .");
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
