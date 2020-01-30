package com.app.dao;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.InstitutePerson;
import com.app.pojos.Student;

public interface ILogin {

	public Student studentLogin(String email,String password);
	public InstitutePerson institutePersonLogin(String email,String password);
	public Admin adminLogin(String email,String password);
	public List<Student> studentList();
}
