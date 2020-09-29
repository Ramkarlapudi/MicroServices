package com.ramkarlapudi.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "userprofile")
public class UserProfileEntity {

	
	public UserProfileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int   userid ;
	@Column(name = "firstname")
	 private String   firstname ;
	@Column(name = "lastname")
	 private String   lastname ;
	@Column(name = "username")
	 private String  username ;
	@Column(name = "email")
	 private String   email ;
	@Column(name = "phone")
	 private String   phone ;
	@Column(name = "country")
	 private String   country ;
	@Column(name = "state")
	 private String   state ;
	@Column(name = "address")
	 private String   address ;
	@Column(name = "pincode")
	 private int   pincode ;
	@Column(name = "passcode")
	 private String   passcode ;
	@Column(name = "verified")
	private String verified ;
	public int getUserid() {
		return userid;
	}
	public String getVerified() {
		return verified;
	}
	public void setVerified(String verified) {
		this.verified = verified;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	@Override
	public String toString() {
		return "UserProfile [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", username="
				+ username + ", email=" + email + ", phone=" + phone + ", country=" + country + ", state=" + state
				+ ", address=" + address + ", pincode=" + pincode + ", passcode=" + passcode + "]";
	}
	 
	
	
}
