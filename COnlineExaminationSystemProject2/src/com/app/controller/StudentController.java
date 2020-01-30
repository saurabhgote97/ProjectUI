package com.app.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ILogin;
import com.app.dao.IStudentDao;
import com.app.pojos.Admin;
import com.app.pojos.Student;
import com.app.pojos.Test;
import com.app.service.ICommon;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired 
	private ICommon commonService;
	@Autowired
	private ILogin dao;
	@Autowired
	private IStudentDao studao;
	
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody Student details)
	{
		System.out.println("Student --> "+details);
		System.out.println("Student --> "+details.getPassword());
		System.out.println("Inside Student Controller");
		Student st = commonService.studentLogin(details.getEmail(),details.getPassword() );
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<Student>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/list")
	private ResponseEntity<?> list()
	{
		System.out.println("Inside Student Controller/list");
		List<Student> st = dao.studentList();
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<List<Student>>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/testList/{sid}")
	private ResponseEntity<?> getTestList(@PathVariable int sid)
	{
		System.out.println("Inside Student Controller/Testlist");
		Set<Test> st = studao.studentTestList(sid);
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<Set<Test>>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/register")
	private ResponseEntity<?> register(@RequestBody Student details)
	{
		System.out.println("Student --> "+details);
		System.out.println("Student --> "+details.getPassword());
		System.out.println("Inside Student Controller");
		Integer st = studao.registerStudent(details);
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<Integer>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/getStuById/{sid}")
	private ResponseEntity<?> getStuById(@PathVariable int sid)
	{
		System.out.println("in get Stu by Id function");
		System.out.println("Inside Student Controller/list");
		Student s = studao.getStudentById(sid);
		
		if(s!= null)
		{
			System.out.println(s.toString());
			return new ResponseEntity<Student>(s,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}




	@PutMapping("/updateStudent")
	private ResponseEntity<?> updateStudent(@RequestBody Student details)
	{
		System.out.println("Student --> "+details);
		System.out.println("Student --> "+details.getPassword());
		System.out.println("Inside Student Controller");
		 this.studao.updateStudent(details);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	


	@GetMapping("/listAssignedTests/{sid}")
	private ResponseEntity<?> listAssignedTest(@PathVariable int sid)
	{
		System.out.println("Inside Student Controller/list");
		Set<Test> list1 = studao.studentAssignedTestList(sid);
		System.out.println("List " +list1);
		if(list1.size() != 0)
		{
			System.out.println(list1.toString());
			return new ResponseEntity<Set<Test>>(list1,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/showTestList")
	private ResponseEntity<?> getTtList()
	{
		System.out.println("Inside Student Controller/Testlist");
		List<Test> st = studao.studentTL();
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<List<Test>>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
}
