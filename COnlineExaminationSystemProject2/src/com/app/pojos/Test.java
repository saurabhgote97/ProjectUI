package com.app.pojos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tests")
public class Test 
{
	private Integer id;
	private String name;
	private int noOfStudents;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date testDate;
	private LocalTime testTime;
	//Many - to one
	private InstitutePerson institutePerson;
	private AssignStatus assignStatus;
	private CompletionStatus completionStatus;
	//-----------------------------------------------------------------------------
	@JsonIgnore
	private Set<QuestionDatabase> questions = new HashSet<QuestionDatabase>();
	@JsonIgnore
	private Set<Student> students = new HashSet<Student>();
	//-----------------------------------------------------------------------------
	
	public Test()
	{
		
	}
	
	

	public Test(String name, int noOfStudents, Date testDate, LocalTime testTime,
			InstitutePerson institutePerson, AssignStatus assignStatus, CompletionStatus completionStatus) {
		super();
		this.name = name;
		this.noOfStudents = noOfStudents;
		this.testDate = testDate;
		this.testTime = testTime;
		this.institutePerson = institutePerson;
		this.assignStatus = assignStatus;
		this.completionStatus = completionStatus;
	}

	//-----------------------------------------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	//////////////////////////////////////////////////////////////////////////////
	@ManyToOne 
	@JoinColumn(name = "institutePerson_id")
	public InstitutePerson getInstitutePerson() {
		return institutePerson;
	}
	public void setInstitutePerson(InstitutePerson institutePerson) {
		this.institutePerson = institutePerson;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "test_date")
	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	
	
	public LocalTime getTestTime() {
		return testTime;
	}

	public void setTestTime(LocalTime testTime) {
		this.testTime = testTime;
	}
	
	

	///////////////////////////////////////////////////////////////////////////////////////
	@Enumerated(EnumType.STRING) //this will add enum names in db
	@Column(length = 10, name = "assign_status")
	public AssignStatus getAssignStatus() {
		return assignStatus;
	}
	public void setAssignStatus(AssignStatus assignStatus) {
		this.assignStatus = assignStatus;
	}

	///////////////////////////////////////////////////////////////////////////////////////
	@Enumerated(EnumType.STRING) //this will add enum names in db
	@Column(length = 10, name = "completion_status")
	public CompletionStatus getCompletionStatus() {
		return completionStatus;
	}
	public void setCompletionStatus(CompletionStatus completionStatus) {
		this.completionStatus = completionStatus;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	@JoinTable(name = "Test_Question",joinColumns = @JoinColumn(name = "test_id"),inverseJoinColumns = @JoinColumn(name ="q_id"))
	public Set<QuestionDatabase> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionDatabase> questions) {
		this.questions = questions;
	}

	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	@ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST},fetch = FetchType.EAGER)
	@JoinTable(name = "Test_Student",joinColumns = @JoinColumn(name = "test_Id"),inverseJoinColumns = @JoinColumn(name ="std_id"))
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	//Helper Methods Student
	

	public void addStudent(Student st)
	{
		students.add(st);
		st.addTest(this);
	}
	public void removeStudent(Student st)
	{
		students.remove(st);	
		st.getTests().remove(null);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//Helper Methods Question
	
	public void addQuestion(QuestionDatabase q)
	{
		questions.add(q);
		q.getTests().add(this);
	}
	public void removeQuestion(QuestionDatabase q)
	{
		questions.remove(q);	
		q.getTests().remove(null);
	}


	////////////////////////////////////////////////////////////////////////////////////////////
	//-----------------------------------------------------------------------------
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", noOfStudents=" + noOfStudents + ", testDate=" + testDate
				+ ", testTime=" + testTime + ", assignStatus=" + assignStatus
				+ ", completionStatus=" + completionStatus + "]";
	}
	

	
	
	
	
}
