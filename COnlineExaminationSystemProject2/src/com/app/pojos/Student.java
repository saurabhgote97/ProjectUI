package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student 
{
	private Integer sid;
	private byte[] image;
	private int age; 
	private String stuName,stuAddr; 
	private long contactNo;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date dob;
	private Gender gender;
	private String email,password; 
	private String educationType;
	private int year;
	private double gpa;
	private Set<Test> tests=new HashSet<>();
	private List<StudentHistory> hisstoryList = new ArrayList<>();
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}



	public Student(int age, String stuName, String stuAddr, long contactNo, Date dob, Gender gender, String email,
			String password, String educationType, int year, double gpa) {
		super();
		this.age = age;
		this.stuName = stuName;
		this.stuAddr = stuAddr;
		this.contactNo = contactNo;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.educationType = educationType;
		this.year = year;
		this.gpa = gpa;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(columnDefinition = "varchar(50)")
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuAddr() {
		return stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	//@Column(nullable = false,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message="Invalid Password format")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonIgnore
	@ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "student",fetch = FetchType.EAGER,orphanRemoval = true)
	public List<StudentHistory> getHisstoryList() {
		return hisstoryList;
	}


	public void setHisstoryList(List<StudentHistory> hisstoryList) {
		this.hisstoryList = hisstoryList;
	}


	@Lob  //col type =longblob
	  public byte[] getImage()
	  {
		return image;
	  }


	public void setImage(byte[] image) 
	{
		this.image = image;
	}
	
	
	@Column(name="edu_type",length=20)
	public String getEducationType() {
		return educationType;
	}
	public void setEducationType(String educationType) {
		this.educationType = educationType;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	//Helper Methods StudentHistory
	
	public void addStudentHistory(StudentHistory sh)
	{
		hisstoryList.add(sh);
		sh.setStudent(this);
	}
	public void removeStudentHistory(StudentHistory sh)
	{
		hisstoryList.remove(sh);
		sh.setStudent(null);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////

	
	////////////////////////////////////////////////////////////////////////////////////////////
	//Helper Methods Test
	
	public void addTest(Test t)
	{
		tests.add(t);
		t.addStudent(this);
	}
	public void removeTest(Test t)
	{
		tests.remove(t);	
		t.addStudent(null);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////


	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stuName == null) ? 0 : stuName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (stuName == null) {
			if (other.stuName != null)
				return false;
		} else if (!stuName.equals(other.stuName))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Student [sid=" + sid + ", age=" + age + ", stuName=" + stuName + ", stuAddr=" + stuAddr + ", contactNo="
				+ contactNo + ", dob=" + dob + ", gender=" + gender + ", email=" + email + ", password=" + password
				+ ", educationType=" + educationType + ", year=" + year + ", gpa=" + gpa + "]";
	}	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////	
	

}
