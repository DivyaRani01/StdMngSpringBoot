package com.demoSpringService;
//importing required packages
import com.demoSpringModel.Course;
import com.demoSpringRepo.CourseRepo;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
//Annotation
@Service
public class CourseService {
 
	//Method 1-> To add the course
	@Autowired
	private CourseRepo crsRepo;
	public String addCourse(Course crs) {
		// TODO Auto-generated method stub
		Course _crs = crsRepo.save(crs);
		if (_crs != null)
			return "Course added Successfully @" + new Date();
		else
		return null;
	}

	//Method 2-> To delete the course
	public String deleteCourse(long crsId) {
		// TODO Auto-generated method stub
		Optional<Course> _crs = crsRepo.findById(crsId);
		if (_crs != null) {
			crsRepo.deleteById(crsId);
			return "Course Deleted Successfully...!";
		} else
		return null;
	}

	////Method 3-> To retrieve the course
	public Optional<Course> getCourseById(long crsId) {
		// TODO Auto-generated method stub
		return crsRepo.findById(crsId);
	}
 
	//Method 4-> To  retrieve the course
	public List<Course> getCourseByName(String crsName) {
		// TODO Auto-generated method stub
		return crsRepo.findByCrsName(crsName);
	}
	
	//Method 5-> To  retrieve the course
	public List<Course> getCourseBycrsPrice(long crsPrice) {
		// TODO Auto-generated method stub
		return crsRepo.findByCrsPrice(crsPrice);
	}
	//Method 6-> To  retrieve the course
	public List<Course> getCourseByDuration(String crsDuration) {
		// TODO Auto-generated method stub
		return crsRepo.findByCrsDuration(crsDuration);
	}
	//Method 7-> To  retrieve all  the course
	public List<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return crsRepo.findAll();
	}
	//Method 8-> To update the course
	public String updateCourse(Course crs) {
		// TODO Auto-generated method stub
		Course _crs = crsRepo.save(crs);
		if (_crs != null)
			return "Course updated Successfully...!" + new Date();
		else
		return null;
	}
	//Method 9-> To sort the course
	public List<Course> sortCourse(String field) {
		// TODO Auto-generated method stub
		return crsRepo.findAll(Sort.by(Direction.ASC,field));
	}

	
}
