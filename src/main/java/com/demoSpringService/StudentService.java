package com.demoSpringService;
//importing required packages
import com.demoSpringModel.Student;
import com.demoSpringRepo.StudentRepo;
//importing required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//Annotation
@Service
public class StudentService {
	
	//injecting repository
	@Autowired
	private StudentRepo StdRepo;

	//creating CRUD methods to student entity
	public String addStudent(Student std) {
		// TODO Auto-generated method stub
		Student _std = StdRepo.save(std);
		if (_std != null)
			return "Student added Successfully @" + new Date();
		else
		return null;
	}

	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return StdRepo.findAll() ;
	}

	public Optional<Student> getStudentById(long stdId) {
		// TODO Auto-generated method stub
		return StdRepo.findById(stdId);
	}

	public List<Student> getStudentBySubject(String stdSub) {
		// TODO Auto-generated method stub
		return StdRepo.findByStdSubject(stdSub);
	}

	public List<Student> getStudentByCourse(String stdCourse) {
		// TODO Auto-generated method stub
		return StdRepo.findByStdCourse(stdCourse);
	}
	
	public String deltStudent(long stdId) {
		// TODO Auto-generated method stub
		Optional<Student> _std = StdRepo.findById(stdId);
		if (_std != null) {
			StdRepo.deleteById(stdId);
			return "Student Deleted Successfully @" + new Date();
		} else
		return null;
	}

	public String updateStudent(Student std) {
		// TODO Auto-generated method stub
		Student _std = StdRepo.save(std);
		if (_std != null)
			return "Student Updated Successfully @" + new Date();
		else
		return null;
	}

	public List<Student> sortStudent(String fields) {
		// TODO Auto-generated method stub
		return StdRepo.findAll(Sort.by(Direction.ASC, fields));
	}

	

}
