package com.wastemanagement.e_wastemanagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity

public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String email;
	private String adress;
	private String contact;
	private String password;
	@Transient
	private String otp;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL)
	private List<Pickup> pickup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	
	public List<Pickup> getPickup() {
		return pickup;
	}
	public void setPickup(List<Pickup> pickup) {
		this.pickup = pickup;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String email, String adress, String contact, String password, String otp,
			List<Pickup> pickup) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.adress = adress;
		this.contact = contact;
		this.password = password;
		this.otp = otp;
		this.pickup = pickup;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", adress=" + adress + ", contact="
				+ contact + ", password=" + password + ", pickup=" + pickup + "]";
	}
	
	
	
}