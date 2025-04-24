package com.jsp.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.Student.util.ResourceStructure;

@RestControllerAdvice
public class ExceptionHandleForStudent {

	@ExceptionHandler(StudentIdNotFound.class)
	public ResponseEntity<ResourceStructure<String>> idNotFoundHandler(StudentIdNotFound e) {

		ResourceStructure<String> rs = new ResourceStructure<String>();
        rs.setData(e.getMsg());
        rs.setMessage("Student data not found successfully.");
        rs.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ResourceStructure<String>>(rs, HttpStatus.NOT_FOUND);
    }
	
}
