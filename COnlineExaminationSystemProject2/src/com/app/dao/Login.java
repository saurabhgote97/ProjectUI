package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Admin;
import com.app.pojos.InstitutePerson;
import com.app.pojos.Student;

@Repository
@Transactional
public class Login implements ILogin
{
	@Autowired
	private SessionFactory sf;
		
	@Override
	public Student studentLogin(String email, String password) {
		System.out.println("Inside Student Dao "+email +" "+password);
		Student s = null;
		String login = "select s from Student s where s.email=:em and s.password=:pass";
		try{
			
		s = sf.getCurrentSession().createQuery(login,Student.class).setParameter("em",email).setParameter("pass",password).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println("No Result or No Unique exception ");
			System.out.println();
			e.printStackTrace();
		}
		return s;
		//return sf.getCurrentSession().createQuery(login,Student.class).setParameter("id",id).getSingleResult();
	}

	@Override
	public InstitutePerson institutePersonLogin(String email, String password) {
		String login = "select s from InstitutePerson s where s.email=:email and s.password=:password";
		return sf.getCurrentSession().createQuery(login,InstitutePerson.class).setParameter("email",email).setParameter("password",password).getSingleResult();
		}

	@Override
	public Admin adminLogin(String email, String password) {
		Admin ad = null;
		String login = "select s from Admin s where s.email=:email and s.password=:password";
		try {
			ad = sf.getCurrentSession().createQuery(login,Admin.class).setParameter("email",email).setParameter("password",password).getSingleResult();
		}
		catch(Exception e)
		{
			System.out.println("No Result or No Unique exception ");
			System.out.println();
			e.printStackTrace();			
		}
		return ad;
	}

	@Override
	public List<Student> studentList() {
		String login = "select s from Student s where id=1";
		return sf.getCurrentSession().createQuery(login,Student.class).getResultList();
	}
	
}
