package com.app.dao;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.mail.search.IntegerComparisonTerm;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.controller.InstutitePersonController;
import com.app.pojos.*;

@Repository
@Transactional
public class StudentDao implements IStudentDao
{
	@Autowired
	private SessionFactory sf;
	/////////////////////////////////////////////////////////////////////////
	
	@Override
	public Integer registerStudent(Student details) {
		return (Integer) sf.getCurrentSession().save(details);
	}
	
	/////////////////////////////////////////////////////////////////////////
	@Override
	public 	List<Test> getAllTestById() {
		int id =1; 
		String jpql="select p from InstitutePerson p join fetch p.testList where p.id = :id";
		InstitutePerson ip = sf.getCurrentSession().createQuery(jpql,InstitutePerson.class).setParameter("id", id).getSingleResult();
		System.out.println("Ip ==> "+ip);
		System.out.println("Ip ==> "+ip.getTestList());
		List<Test> list = ip.getTestList();
		return list;
	}

	@Override
	public Set<Test> studentTestList(int sid) { 
		String jpql="select s from Student s join fetch s.tests where s.id = :id";
		Student ip = sf.getCurrentSession().createQuery(jpql,Student.class).setParameter("id", sid).getSingleResult();
		System.out.println("Ip ==> "+ip);
		System.out.println("Ip ==> "+ip.getTests());
		Set<Test> list = ip.getTests();
		return list;
	}

	@Override
	public Set<QuestionDatabase> getQuestionList(int id) { 
		String jpql="select t from Test t join fetch t.questions where t.id = :id";
		Test ip = sf.getCurrentSession().createQuery(jpql,Test.class).setParameter("id", id).getSingleResult();
		System.out.println("Ip ==> "+ip);
		System.out.println("Ip ==> "+ip.getQuestions());
		Set<QuestionDatabase> list = ip.getQuestions();
		return list;
	}

	@Override
	public void insertStudentHistory(StudentHistory sh,int id) {
		Student s = sf.getCurrentSession().get(Student.class, id);
		sf.getCurrentSession().save(sh);
		s.addStudentHistory(sh);
		sf.getCurrentSession().saveOrUpdate(s);
	}

	@Override
	public List<StudentHistory> listOfStudentHistory(int id) {
		String jpql = "select s from Student s join fetch s.hisstoryList where sid=:id";
		Student s=  sf.getCurrentSession().createQuery(jpql,Student.class).setParameter("id", id).getSingleResult();
		return s.getHisstoryList();
	}

	@Override
	public Integer registerInstitutePerson(InstitutePerson details) {
		return (Integer) sf.getCurrentSession().save(details);
		
	}
	/////////////////////////////////////////////////////////////////////

	@Override
	public InstitutePerson getIpById(int iid11) 
	{
		String jpql="select q from InstitutePerson q where q.id=:iid";
		InstitutePerson ip = sf.getCurrentSession().createQuery(jpql,InstitutePerson.class).setParameter("iid", iid11).getSingleResult();
		return ip;
	
	}
	
	@Override
	public Student getStudentById(int id) 
	{
		String jpql="select s from Student s   where s.sid=:s";
		Student ip = sf.getCurrentSession().createQuery(jpql,Student.class).setParameter("s",id).getSingleResult();
	
		return ip;
	}


	@Override
	public int updateStudent(Student s) 
	{
		this.sf.getCurrentSession().saveOrUpdate(s);		
		return 0;
	}
	@Override
	public int updateIp(InstitutePerson ip)
	{
		System.out.println();
		System.out.println(ip);
		this.sf.getCurrentSession().saveOrUpdate(ip);
		return 0;
	}
	
	@Override
	public void registerQuestion(QuestionDatabase que) {
		this.sf.getCurrentSession().save(que);
		
	}
	@Override
	public Integer registerTest(Test details,int iid) {
		// TODO Auto-generated method stub
	  
		System.out.println("details ; ;; ; ; ;"+details.toString()+"iid = = = "+iid);
		
		this.sf.getCurrentSession().save(details);
		
		
		String jpql="select p from InstitutePerson p join fetch p.testList where p.id = :id";
		InstitutePerson ip = sf.getCurrentSession().createQuery(jpql,InstitutePerson.class).setParameter("id", iid).getSingleResult();
		
	
		System.out.println("in ger test dao "+ip.toString());
		
		ip.getTestList().add(details);
		 ip.addTest(details);
		 this.sf.getCurrentSession().saveOrUpdate(ip);
			 
	     
		
		return null;
	}
	

	@Override
	public Set<Test> studentAssignedTestList(int stuId) 
  {
	//		String login = "select s from Student s where s.email=:em and s.password=:pass";
		System.out.println("Inside student List");
		Set<Test> listAssigned=new HashSet<>();
		int id11 =stuId; 
		String jpql="select s from Student s join fetch s.tests where s.id = :id1";
		Student ip = sf.getCurrentSession().createQuery(jpql,Student.class).setParameter("id1", id11).getSingleResult();
		System.out.println("Ip ==> "+ip);
		System.out.println("Ip ==> "+ip.getTests());
		Set<Test> list = ip.getTests();
		
		for (Test test : list)
		{
		System.out.println("STATUS  = "+test.getAssignStatus().toString());
			if(test.getAssignStatus().toString().equals("ASSIGNED") && test.getCompletionStatus().toString().equals("PENDING") )
			{
				System.out.println("test status = " +test.getAssignStatus().toString());
		      	listAssigned.add(test);	
			}
		
		}
		
		return  listAssigned;
		
	}

//	@Override
//	public void addQuestionToTest(int tid, int qid) 
//	{
//		System.out.println(tid);
//		System.out.println(qid);
//		String jpql="select t from Test t  where t.id=:id11";
//		Test t = sf.getCurrentSession().createQuery(jpql,Test.class).setParameter("id11", tid).getSingleResult();
//	
//	//	QuestionDatabase
//
//		String jpql1="select q from QuestionDatabase q  where q.id=:id11";
//		QuestionDatabase que = sf.getCurrentSession().createQuery(jpql1,QuestionDatabase.class).setParameter("id11", qid).getSingleResult();
//		
//		t.addQuestion(que);
//		
//		//System.out.println("question "+ que.toString()+"added to test "+t.toString());
//		sf.getCurrentSession().saveOrUpdate(t);
//	}

	@Override
	public List<QuestionDatabase> getAllQuestions() 
	{
		 
		String jpql="select q from QuestionDatabase q";
		List<QuestionDatabase> list = sf.getCurrentSession().createQuery(jpql,QuestionDatabase.class).getResultList();
		return list;
	}

	@Override
	public void addquestion(int tid, int qid) {
		String jpql ="select t from Test t where t.id=:id";
		Test t = sf.getCurrentSession().createQuery(jpql,Test.class).setParameter("id", tid).getSingleResult();
		System.out.println("Test " +t);
		
		String jpql2 ="select q from QuestionDatabase q where q.id=:id2";
		QuestionDatabase q= sf.getCurrentSession().createQuery(jpql2,QuestionDatabase.class).setParameter("id2", qid).getSingleResult();
		System.out.println("Question  " +q);
		
		t.addQuestion(q);
		//sf.getCurrentSession().saveOrUpdate(t);
		
		
		
	}

	@Override
	public List<Test> studentTestList() 
	{
		String jpql="select t from Test t";

		//String kpql="select s from Student s";
		
//		List<Student> Slist=sf.getCurrentSession().createQuery(kpql,Student.class).getResultList();
	//	System.out.println(Slist);
		List<Test> ip = sf.getCurrentSession().createQuery(jpql,Test.class).getResultList();
		System.out.println("Ip ==> "+ip);
		return ip;
	
	}

	@Override
	public List<Student> StudentList() {
	
		String jpql="select s from Student s";
		List<Student> ip = sf.getCurrentSession().createQuery(jpql,Student.class).getResultList();
		System.out.println("Ip ==> "+ip);
		return ip;
	
	}

	@Override
	public List<InstitutePerson> ipList() {
		String jpql="select s from InstitutePerson s";
		List<InstitutePerson> ip = sf.getCurrentSession().createQuery(jpql,InstitutePerson.class).getResultList();
		System.out.println("Ip ==> "+ip);
		return ip;
		}

	@Override
	public List<Test> ipTestList(int iid) {
		String jpql="select s from InstitutePerson s join fetch s.testList where s.id = :iid";
		InstitutePerson ip = sf.getCurrentSession().createQuery(jpql,InstitutePerson.class).setParameter("iid", iid).getSingleResult();
		System.out.println("Ip ==> "+ip);
		System.out.println("Ip ==> "+ip.getTestList());
		List<Test> list = ip.getTestList();
		return list;
	}

	@Override
	public List<Test> studentTL() {
	
		String jpql="select t from Test t join fetch t.questions";

		//String kpql="select s from Student s";
		
//		List<Student> Slist=sf.getCurrentSession().createQuery(kpql,Student.class).getResultList();
	//	System.out.println(Slist);
		List<Test> p = sf.getCurrentSession().createQuery(jpql,Test.class).getResultList();
		System.out.println("Ip ==> "+p);
		List<Test> ip = new ArrayList<>();

		for (Test test : p)
		{
			System.out.println("inside");
			System.out.println(test.getQuestions().size());
			System.out.println("Out");
			
		//System.out.println("STATUS  = "+test.getAssignStatus().toString());
			if(test.getAssignStatus().toString().equals("ASSIGNED") && test.getCompletionStatus().toString().equals("PENDING") && test.getQuestions().size() != 0 )
			{
				System.out.println("test status = " +test.getAssignStatus().toString());
		      	ip.add(test);	
			}
		
		}
		
		
		return ip;
		
	}






}
