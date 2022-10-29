package com.demoSpringController;
//importing required classes and packages
import java.util.List;
import java.util.Optional;
import com.demoSpringModel.Student;
import com.demoSpringService.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//Class-level annotation
@RestController
public class StudentController {
	
	//injecting service
	@Autowired
	private StudentService stdService;
	
	//Mapping Method 1-> to add the Student
	@PostMapping("/add")
	public ResponseEntity<String> addStudent(@RequestBody Student std) {
		String status = stdService.addStudent(std);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
    //Mapping Method 2-> to retrieve all the student
	@GetMapping("/fetch/all")
	public ResponseEntity<List<Student>> getAllStudents() {
		return new ResponseEntity<>(stdService.getAllStudent(), HttpStatus.OK);
	}

	//Mapping Method 3-> to retrieve the Student via studentId
	@GetMapping("/fetch/id/{stdId}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable long stdId) {
		return new ResponseEntity<>(stdService.getStudentById(stdId), HttpStatus.OK);
	}

	//Mapping Method 4-> to retrieve the Student via studentcourse
	@GetMapping("/fetch/Course/{std}")
	public ResponseEntity<List<Student>> getStudentByCourse(@PathVariable String stdCourse) {
		return new ResponseEntity<>(stdService.getStudentByCourse(stdCourse), HttpStatus.OK);
	}

	//Mapping Method 5-> to retrieve the Student via studentsubject
	@GetMapping("/fetch/subject/{stdSubject}")
	public ResponseEntity<List<Student>> getStudentBySubject(@PathVariable String  stdSub) {
		return new ResponseEntity<>(stdService.getStudentBySubject(stdSub), HttpStatus.OK);
	}

	//Mapping Method 6-> to updating/patching the Student 
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(@RequestBody Student std) {
		String status = stdService.updateStudent(std);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	////Mapping Method 7-> to delete the Student via studentId
	@DeleteMapping("/remove/{stdId}")
	public ResponseEntity<String> deleteStudent(@PathVariable long stdId) {
		String status = stdService.deltStudent(stdId);
		if (status != null)
			return new ResponseEntity<>(status, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(status, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//Mapping Method 8-> to  perform sorting for specific field
	@GetMapping("/fetch/sort/{field}")
	public ResponseEntity<List<Student>> sortStudent(@PathVariable String field) {
		return new ResponseEntity<>(stdService.sortStudent(field),HttpStatus.OK);
	}
	
	
	
	
	
	

}
