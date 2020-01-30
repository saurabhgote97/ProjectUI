package com.app.pojos;

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
@Table(name = "institute_person")
public class InstitutePerson {

	private Integer id;
	private byte[] image;
	private int age; 
	private String personName,stuAddr;
	private String instituteName;
	private long contactNo;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date dob; 
	private String email,password; 
	private Gender gender;
	
	private List<Test> testList=new ArrayList<>();
	
	
	public InstitutePerson() {
	
	}
	

	public InstitutePerson(int age, String personName, String stuAddr, String instituteName, long contactNo, Date dob,
			String email, String password, Gender gender) {
		super();
		this.age = age;
		this.personName = personName;
		this.stuAddr = stuAddr;
		this.instituteName = instituteName;
		this.contactNo = contactNo;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instName) {
		this.instituteName = instName;
	}

/////////////////////////////////////////////////////////////////////	
	
	
	@OneToMany(mappedBy = "institutePerson",
			cascade = CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval = true)
	@JsonIgnore
	public List<Test> getTestList() {
		return testList;
	}
	public void setTestList(List<Test> testList) {
		this.testList = testList;
	}


/////////////////////////////////////////////////////////////////////


	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}




	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
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


	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////
	//Helper Methods Student
	

	public void addTest(Test t)
	{
		testList.add(t);
		t.setInstitutePerson(this);
	}
	public void removeTest(Test t)
	{
		testList.remove(t);
		t.setInstitutePerson(null);
	}

	////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "InstitutePerson [id=" + id + ", age=" + age + ", personName=" + personName + ", stuAddr=" + stuAddr
				+ ", instituteName=" + instituteName + ", contactNo=" + contactNo + ", dob=" + dob + ", email=" + email
				+ ", password=" + password + ", gender=" + gender + "]";
	}


	
	
	
}
