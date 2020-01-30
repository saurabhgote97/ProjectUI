package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "admin")
public class Admin 
{
	private Integer id;
	private byte[] image;
	private int age; 
	private String name;
	private long contactNo;
	@JsonFormat(pattern="yyyy-MM-dd",timezone = "IST")
	private Date dob; 
	private String email,password; 
	private Gender gender;
	

	////////////////////////////////////////////////////////////////////////////////////////
	public Admin() 
	{
	
	}

	
	public Admin(int age, String name, long contactNo, Date dob, String email, String password, Gender gender) {
		super();
		this.age = age;
		this.name = name;
		this.contactNo = contactNo;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.gender = gender;
	}


	////////////////////////////////////////////////////////////////////////////////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
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

	@Column(columnDefinition = "varchar(50)")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Admin [id=" + id + ", age=" + age + ", name=" + name + ", contactNo=" + contactNo + ", dob=" + dob
				+ ", email=" + email + ", password=" + password + ", gender=" + gender + "]";
	}
	
}
