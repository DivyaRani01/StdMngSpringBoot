package com.demoSpringController;
//importing required packages modules
import com.demoSpringModel.Course;
import com.demoSpringService.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
//importing required classes
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

//class level annotation
@RestController
public class CourseController {
	
	//injecting service
	@Autowired
	private CourseService crsService;
	
	//Mapping Method 1-> to add the course
	@PostMapping("/add")
	public ResponseEntity<String>addCourse(@RequestBody Course crs){
		String status = crsService.addCourse(crs);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Mapping Method 2-> to delete the course
	@DeleteMapping("/remove/{crsId}")
	public ResponseEntity<String> deleteCourse(@PathVariable long lapId) {
		String status = crsService.deleteCourse(lapId);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Mapping Method 3-> to retrieve the course via courseId
	@GetMapping("/fetch/id/{crsId}")
	public ResponseEntity<Optional<Course>> getCourseById(@PathVariable long crsId) {
		return new ResponseEntity<>(crsService.getCourseById(crsId), HttpStatus.OK);
	}
	
	//Mapping Method 4-> to retrieve the course via courseName
	@GetMapping("/fetch/ram/{crsName}")
	public ResponseEntity<List<Course>> getCourseByName(@PathVariable String crsName) {
		return new ResponseEntity<>(crsService.getCourseByName(crsName), HttpStatus.OK);
	}
	
	//Mapping Method 5-> to retrieve  the course via coursePrice
	@GetMapping("/fetch/price/{crsPrice}")
	public ResponseEntity<List<Course>> getCourseByPrice(@PathVariable long crsPrice) {
		return new ResponseEntity<>(crsService.getCourseBycrsPrice(crsPrice), HttpStatus.OK);
	}

	//Mapping Method 6-> to retrieve the course via courseDuration
	@GetMapping("/fetch/duration/{crsDuration}")
	public ResponseEntity<List<Course>> getCourseByDuration(@PathVariable String crsDuration) {
		return new ResponseEntity<>(crsService.getCourseByDuration(crsDuration), HttpStatus.OK);
	}

	//Mapping Method 7-> to retrieve  all the course from the db
	@GetMapping("/fetch")
	public ResponseEntity<List<Course>>getAllCourse() {
		return new ResponseEntity<>(crsService.getAllCourse(),HttpStatus.OK);
	}
	
	//Mapping Method 8-> to update the course
	@PutMapping("/update")
	public ResponseEntity<String> updateCourse(@RequestBody Course crs) {
		String status = crsService.updateCourse(crs);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Mapping Method 9-> to sort the course according the specific field
	@GetMapping("/fetch/sort/{field}")
	public ResponseEntity<List<Course>> sortCourse(@PathVariable String field) {
		return new ResponseEntity<>(crsService.sortCourse(field), HttpStatus.OK);
	}

	

}
