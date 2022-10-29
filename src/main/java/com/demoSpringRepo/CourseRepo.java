package com.demoSpringRepo;
//importing required packages and classes
import java.util.List;
import com.demoSpringModel.Course;
import org.springframework.data.jpa.repository.JpaRepository;

//creating interface which extends jparepository
public interface CourseRepo extends JpaRepository<Course , Long> {
	
    //using findby method to sort the data 
	List<Course>findByCrsName(String crsName);
	
	List<Course>findByCrsDuration(String CrsDuration);
	
	List<Course>findByCrsPrice(long crsPrice);
	

}
