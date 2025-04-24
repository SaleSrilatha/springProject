package com.jsp.Student.util;

import lombok.Data;

@Data
public class ResourceStructure<T> {

	private int status;
	private T data;
	private String message;
	
}
