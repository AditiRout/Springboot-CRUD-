package com.example.Springdemo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class StudentService {
	//from database
	private final StudentRepository studentRepository;
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	public void addNewStudent(Student student) {
		Optional<Student>studentByEmail=studentRepository.findStudentByEmail(student.getEmail());
		if(studentByEmail.isPresent()) {
			throw new IllegalStateException("email already registered");
		}
		studentRepository.save(student);
		// TODO Auto-generated method stub
		
	}
	public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("doesnt exist");
		}
		
		
		studentRepository.deleteById(studentId);
		
	}

}
