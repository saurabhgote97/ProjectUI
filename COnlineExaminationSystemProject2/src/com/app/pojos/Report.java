package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "reports")
public class Report 
{
	private Integer id;
	private int noOfStudents;
	private int noOfTest;
	private int noOfStudentsPass;
	private int noOfStudentsFail;
	private int noOfStudentsAttended;
	
	public Report() 
	{
		
	}
	
	public Report(int noOfStudents, int noOfTest, int noOfStudentsPass, int noOfStudentsFail,
			int noOfStudentsAttended) {
		this.noOfStudents = noOfStudents;
		this.noOfTest = noOfTest;
		this.noOfStudentsPass = noOfStudentsPass;
		this.noOfStudentsFail = noOfStudentsFail;
		this.noOfStudentsAttended = noOfStudentsAttended;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public int getNoOfTest() {
		return noOfTest;
	}

	public void setNoOfTest(int noOfTest) {
		this.noOfTest = noOfTest;
	}

	public int getNoOfStudentsPass() {
		return noOfStudentsPass;
	}

	public void setNoOfStudentsPass(int noOfStudentsPass) {
		this.noOfStudentsPass = noOfStudentsPass;
	}

	public int getNoOfStudentsFail() {
		return noOfStudentsFail;
	}

	public void setNoOfStudentsFail(int noOfStudentsFail) {
		this.noOfStudentsFail = noOfStudentsFail;
	}

	public int getNoOfStudentsAttended() {
		return noOfStudentsAttended;
	}

	public void setNoOfStudentsAttended(int noOfStudentsAttended) {
		this.noOfStudentsAttended = noOfStudentsAttended;
	}

	@Override
	public String toString() {
		return "Report [noOfStudents=" + noOfStudents + ", noOfTest=" + noOfTest + ", noOfStudentsPass="
				+ noOfStudentsPass + ", noOfStudentsFail=" + noOfStudentsFail + ", noOfStudentsAttended="
				+ noOfStudentsAttended + "]";
	}
	
	
	
	
}
