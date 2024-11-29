package com.wastemanagement.e_wastemanagement.corprativeentity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Corprative {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String companyName;
	private String email;
	private String adress;
	private String contact;
	private String password;
	@Transient
	private String otp;
	@OneToMany(mappedBy="corprative")
	
	private List<PickupCorprater> pickup;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	public Corprative(int id, String userName, String email, String adress, String contact, String password,
			String otp) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.email = email;
		this.adress = adress;
		this.contact = contact;
		this.password = password;
		this.otp = otp;
	}
	public Corprative() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Corprative [id=" + id + ", companyName=" + companyName + ", email=" + email + ", adress=" + adress
				+ ", contact=" + contact + ", password=" + password + "]";
	}
	
}
