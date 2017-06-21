package com.wavelabs.enrollment.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "firstname", nullable = false)
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "gender")
	private Gender gender;

	@Column(name = "mothername")
	private String motherName;

	@Column(name = "fathername")
	private String fatherName;

	@Column(name = "highestqualification")
	private String highestQualification;

	@Column(name = "experience")
	private Integer experience;

	@Column(name = "intrestedareas")
	private String intrestedAreas;

	@Column(name = "others")
	private String others;

	@Column(name = "status")
	private Status status;

	@Column(name = "logintype")
	private LoginType loginType;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Address.class)
	@JoinColumn(name = "address", unique = true)
	private Address address;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = AutherizationTokens.class)
	private AutherizationTokens tokens;

	public AutherizationTokens getTokens() {
		return tokens;
	}

	public void setTokens(AutherizationTokens tokens) {
		this.tokens = tokens;
	}

	public String getFirstName() {
		return firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getHighestQualification() {
		return highestQualification;
	}

	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public String getIntrestedAreas() {
		return intrestedAreas;
	}

	public void setIntrestedAreas(String intrestedAreas) {
		this.intrestedAreas = intrestedAreas;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
