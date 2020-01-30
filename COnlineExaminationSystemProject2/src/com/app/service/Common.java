package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ILogin;
import com.app.pojos.Admin;
import com.app.pojos.InstitutePerson;
import com.app.pojos.Student;

@Service
@Transactional
public class Common implements ICommon
{
	@Autowired
	private ILogin login;

	@Override
	public Student studentLogin(String email, String password) {
		System.out.println("Inside Student Service "+email+" "+password);
		Student st = login.studentLogin(email, password);
		return st;
	}

	@Override
	public InstitutePerson institutePersonLogin(String email, String password) {
		InstitutePerson ip = login.institutePersonLogin(email, password);
		return ip;
	}

	@Override
	public Admin adminLogin(String email, String password) {
		Admin ad = login.adminLogin(email, password);
		return ad;
	}
	 
}
