package com.jsp.Student.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentIdNotFound extends RuntimeException{

	private String msg="Student id not found";
	
}
