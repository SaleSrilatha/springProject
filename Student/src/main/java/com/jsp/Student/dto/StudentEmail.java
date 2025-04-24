package com.jsp.Student.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentEmail {

	private String to;
	private String subject;
	private String body;
	private String attachment;
	
	
	
	
	public StudentEmail(String to, String subject, String body, String attachment) {
		super();
		this.to = to;
		this.subject = subject;
		this.body = body;
		this.attachment = attachment;
	}
	
	
	
}
