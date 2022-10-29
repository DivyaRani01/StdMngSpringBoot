package com.demoSpringModel;
//importing required classes
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	// @ID This annotation specifies the primary key of the entity
	@Id
	private long stdId;
	private String stdName;
	private String stdContact;
	private String StdSubject;
	private String StdCourse;
	//ONE TO MANY mapping One student can have many course
	@OneToMany
	@JoinColumn(name="stdId")
	private List<Course>stdCourse;
	
	
	

}