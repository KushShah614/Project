package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository students;
	@PostMapping("/students/add")
	
	public String Studentadd(Student stu)
	{
		try
		{
			students.save(stu);
			return "Data Inserted";
		}
		catch(Exception ex)
		{
			 return ex.getMessage();
		}
	}
	
	@GetMapping("/students/display")
	public String Studentdisplay(Model model)
	{
		List<Student> student_list=(List<Student>)students.findAll();
		model.addAttribute("/students/display",student_list);
		return "display";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editstudent(@PathVariable("id")Integer id,Model model)
	{
		Student stu= students.findById(id).get();
		
		model.addAttribute("student",stu);
		return "edit";
		
	}
	
	@PostMapping("/students/edit")
	public String editStudent(Student stu)
	{
		Integer id=stu.getId();
		String name=stu.getName();
		Integer marks=stu.getMarks();
		Student studentDB=stu.findById1(id).get();
		
		studentDB.setName(name);
		studentDB.setMarks(marks);
		
		students.save(studentDB);
		
		return "redirect:/students/display";
	}
	
	@PostMapping("/students/del")
	public String Studentdel(int Id)
	{
		try
		{
			students.deleteById(Id);
			return "Record Deleted";
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		return "Error";
	}
}