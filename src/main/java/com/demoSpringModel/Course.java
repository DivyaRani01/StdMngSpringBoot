package com.demoSpringModel;
//importing required packages and classes
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
	     
	     // @ID This annotation specifies the primary key of the entity
		// @GeneratedValue This annotation is used to specify the primary  key generation strategy to use 
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)  
		public long crsId;
		public String crsName;
		public String crsPassword;
		public long crsPrice;
		public String crsDuration;

	}
