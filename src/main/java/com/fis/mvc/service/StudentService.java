package com.fis.mvc.service;

import java.util.List;

import com.fis.mvc.model.Student;


public interface StudentService {
	public List<Student> getAllStudents();
	public Student getStudentById(int id);
	public Student createStudent(Student s);
	public Student updateStudent(Student s);
	public void deleteStudentById(int id);
	

}
