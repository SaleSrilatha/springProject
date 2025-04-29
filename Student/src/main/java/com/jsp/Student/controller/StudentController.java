package com.jsp.Student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Student.dto.StudentEmail;
import com.jsp.Student.entity.Student;
import com.jsp.Student.service.StudentService;
import com.jsp.Student.util.ResourceStructure;

import jakarta.mail.MessagingException;

@RestController
public class StudentController {
   public static void main (String[] args){
	@Autowired
	private StudentService service;
	
	 @PostMapping("/save")
	    public ResponseEntity<ResourceStructure<StudentEmail>> saveStudent(@RequestBody StudentEmail student) throws MessagingException {
				return service.save(student);
			
	    }
	
	 @GetMapping("/save")
	    public ResponseEntity<ResourceStructure<Student>> saveStudent(@RequestBody Student student) throws MessagingException {
				return service.saveStudent(student);
			
	    }
	 
	 @GetMapping("/mail")
		public void sendEmail(@RequestBody StudentEmail student) {
//			System.out.println(student);
			service.sendMsg(student);    
		}
		
		
		@GetMapping("/otp")
		public void sendOtp(@RequestBody StudentEmail student) {
//			System.out.println(student);
			service.sendOtp(student);    
		}
		
		@GetMapping("/attach")
		public void sendAttach(@RequestBody StudentEmail student) throws MessagingException {
//			System.out.println(student);
			service.sendAttachment(student);    
		}
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
	        service.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }
		
		@PostMapping("/fetch")
	    public ResponseEntity<ResourceStructure<Student>> fetch(@RequestParam int id) throws MessagingException {
			return service.fetchStudent(id);
	    }
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
		
		
}
