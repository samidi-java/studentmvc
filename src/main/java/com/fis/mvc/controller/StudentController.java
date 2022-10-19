package com.fis.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.fis.mvc.model.Student;
import com.fis.mvc.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	
	
	
	@Autowired
	private StudentServiceImpl service;
	
	
	@GetMapping("/")
	public String index(Model model)
	{
		List<Student> studentList=service.getAllStudents();
		
		model.addAttribute("studentList",studentList);
		return "index";
	}
	
	@GetMapping("/create-student")
	public String createStudent(Model model)
	{
		Student student=new Student();
		model.addAttribute("command",student);
		return "create-student";
	}
	
	@PostMapping("/save")
	public String saveStudent(@Valid @ModelAttribute Student student,Model model,BindingResult brs)
	{
		if(brs.hasErrors())
		{
			return "create-student";
		}
		service.createStudent(student);
		model.addAttribute("student",student);
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") Integer id,Model model)
	{
		Student student=service.getStudentById(id);
		model.addAttribute("student",student);
		return "edit-student";
	}
	
	

	@PostMapping("edit/update")
	public String updateStudent(@ModelAttribute Student student,Model model)
	{
		service.updateStudent(student);
		model.addAttribute("student",student);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id,Model model)
	{
		service.deleteStudentById(id);
		return "redirect:/";
	}

}
