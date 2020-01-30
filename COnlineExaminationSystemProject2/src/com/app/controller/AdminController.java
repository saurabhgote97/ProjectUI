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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IStudentDao;
import com.app.pojos.Admin;
import com.app.pojos.InstitutePerson;
import com.app.pojos.Student;
import com.app.pojos.Test;
import com.app.service.ICommon;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController 
{

	@Autowired 
	private ICommon commonService;
	@Autowired 
	private IStudentDao dao;
	
	@PostMapping("/login")
	private ResponseEntity<?> login(@RequestBody Admin details)
	{
		Admin ad = commonService.adminLogin(details.getEmail(),details.getPassword() );
		if(ad != null)
			return new ResponseEntity<Admin>(ad,HttpStatus.OK);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	@PostMapping("/registerInstPerson")
	private ResponseEntity<?> registerInstPerson(@RequestBody InstitutePerson details)
	{
		System.out.println("Inside Student Controller/list");
		Integer st = dao.registerInstitutePerson(details);

		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<Integer>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/showTestList")
	private ResponseEntity<?> getTtList()
	{
		System.out.println("Inside Student Controller/Testlist");
		List<Test> st = dao.studentTestList();
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<List<Test>>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/showStudentList")
	private ResponseEntity<?> getStList()
	{
		System.out.println("Inside Student Controller/Testlist");
		List<Student> st = dao.StudentList();
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<List<Student> >(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/showIPList")
	private ResponseEntity<?> getIpList()
	{
		System.out.println("Inside Student Controller/Testlist");
		List<InstitutePerson> st = dao.ipList();
		if(st != null)
		{
			System.out.println(st);
			return new ResponseEntity<List<InstitutePerson>>(st,HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
