package com.app.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "questions")
public class QuestionDatabase
{
	
	private Integer id;
	private String question;
	private String op1;
	private String op2;
	private String op3;
	private String op4;
	private String answer;
	@JsonIgnore
	private Set<Test> tests = new HashSet<Test>();
	
	public QuestionDatabase() 
	{
		
	}
	
	public QuestionDatabase(String question, String op1, String op2, String op3, String op4, String answer) 
	{
		this.question = question;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.answer = answer;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@ManyToMany(mappedBy = "questions",fetch = FetchType.EAGER)
	public Set<Test> getTests() {
		return tests;
	}

	public void setTests(Set<Test> tests) {
		this.tests = tests;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	//Helper Methods

	public void addTest(Test t)
	{
		tests.add(t);
		t.addQuestion(this);
	}
	public void removeTest(Test t)
	{
		tests.remove(t);	
		t.addQuestion(null);
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionDatabase other = (QuestionDatabase) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "QuestionDatabase [id=" + id + ", question=" + question + ", op1=" + op1 + ", op2=" + op2 + ", op3="
				+ op3 + ", op4=" + op4 + ", answer=" + answer + "]";
	}
	
	
}
