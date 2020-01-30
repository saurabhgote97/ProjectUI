package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "student_history")
public class StudentHistory 
{
	private Integer id;
	private int noOfQuestions;
	private int noOfAttemptedQuestions;
	private int noOfAnsweredQuestion;
	private int marksObtained;
	private double percentage;
	private Remark remark;
	private Student student;
	private int tid;
	
	public StudentHistory()
	{
		
	}

	public StudentHistory(int noOfQuestions, int noOfAttemptedQuestions, int noOfAnsweredQuestion, int marksObtained,
			double percentage, Remark remark,Student student,int tid) {
		super();
		this.noOfQuestions = noOfQuestions;
		this.noOfAttemptedQuestions = noOfAttemptedQuestions;
		this.noOfAnsweredQuestion = noOfAnsweredQuestion;
		this.marksObtained = marksObtained;
		this.percentage = percentage;
		this.remark = remark;
		this.student =student;
		this.tid = tid;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public int getNoOfAttemptedQuestions() {
		return noOfAttemptedQuestions;
	}

	public void setNoOfAttemptedQuestions(int noOfAttemptedQuestions) {
		this.noOfAttemptedQuestions = noOfAttemptedQuestions;
	}

	public int getNoOfAnsweredQuestion() {
		return noOfAnsweredQuestion;
	}

	public void setNoOfAnsweredQuestion(int noOfAnsweredQuestion) {
		this.noOfAnsweredQuestion = noOfAnsweredQuestion;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Enumerated(EnumType.STRING)
	public Remark getRemark() {
		return remark;
	}

	public void setRemark(Remark remark) {
		this.remark = remark;
	}

	@ManyToOne
	@JoinColumn(name = "student_id")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "StudentHistory [id=" + id + ", noOfQuestions=" + noOfQuestions + ", noOfAttemptedQuestions="
				+ noOfAttemptedQuestions + ", noOfAnsweredQuestion=" + noOfAnsweredQuestion + ", marksObtained="
				+ marksObtained + ", percentage=" + percentage + ", remark=" + remark + ", student=" + student
				+ ", tid=" + tid + "]";
	}
	
	
	
	
}
