package com.fis.mvc.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.mvc.controller.StudentController;
import com.fis.mvc.dao.StudentRepository;
import com.fis.mvc.model.Student;

@Service
public class StudentServiceImpl  implements StudentService{

	private static final Logger LOGGER=LoggerFactory.getLogger(StudentServiceImpl.class);
	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudents() {
		LOGGER.info("getAllStudents() method called"); 
		return repository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		LOGGER.info("getStudentById() method called"); 
		return repository.findById(id).get();
	}

	@Override
	public Student createStudent(Student s) {
		LOGGER.info("createStudent() method called"); 
		return repository.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		LOGGER.info("updateStudent() method called"); 
		return repository.save(s);
	}

	@Override
	public void deleteStudentById(int id) {
		LOGGER.info("deleteStudentById() method called"); 
		repository.deleteById(id);
	}

}
