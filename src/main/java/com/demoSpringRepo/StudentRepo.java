package com.demoSpringRepo;

//importing required packages and classes
import java.util.List;
import com.demoSpringModel.Student;
import org.springframework.data.jpa.repository.JpaRepository;

//creating interface 
public interface  StudentRepo extends JpaRepository<Student , Long> {
	
	//using findby to sort the data from database
	List<Student> findByStdCourse(String stdCourse);

	List<Student> findByStdSubject(String  stdSubject);

}
