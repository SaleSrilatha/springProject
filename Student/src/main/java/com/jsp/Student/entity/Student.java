package com.jsp.Student.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	private String name;
	@Column(unique = true)
	private String email;
	private String pwd;
	private double marks;
	
	
	public Student(String name, String email, String pwd, double marks) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.marks = marks;
	}
	
	
	
	
}
