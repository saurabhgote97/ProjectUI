package com.app.dao;

import java.util.List;
import java.util.Set;

import com.app.pojos.InstitutePerson;
import com.app.pojos.QuestionDatabase;
import com.app.pojos.Student;
import com.app.pojos.StudentHistory;
import com.app.pojos.Test;

public interface IStudentDao 
{
	Integer registerStudent(Student details);
	List<Test> getAllTestById();
	Set<Test> studentTestList(int sid);
	List<Test> ipTestList(int iid);
	Set<QuestionDatabase> getQuestionList(int id);
	void insertStudentHistory(StudentHistory sh,int id);
	List<StudentHistory> listOfStudentHistory(int id);
	Integer registerInstitutePerson(InstitutePerson details);
	InstitutePerson getIpById(int iid11) ;
	public Student getStudentById(int id) ;
	public int updateStudent(Student s) ;
	public int updateIp(InstitutePerson ip);
	public void registerQuestion(QuestionDatabase que);
	public Integer registerTest(Test details,int iid);
	public Set<Test> studentAssignedTestList(int stuId) ;
	//public void addQuestionToTest(int tid, int qid);
	public void addquestion(int tid, int qid);
	public List<QuestionDatabase> getAllQuestions() ;
	List<Test> studentTestList();
	List<Student> StudentList();
	List<InstitutePerson> ipList();
	List<Test> studentTL();
	
}
