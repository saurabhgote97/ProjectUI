package com.app.service;

import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;
import com.app.pojos.InstitutePerson;
import com.app.pojos.Student;



public interface ICommon 
{
	public Student studentLogin(String email,String password);
	public InstitutePerson institutePersonLogin(String email,String password);
	public Admin adminLogin(String email,String password);
}
