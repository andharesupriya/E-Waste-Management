package com.wastemanagement.e_wastemanagement.sellingentity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserDtls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idsell;

	private String usernamesell;

	private String contactsell;

	private String emailsell;

	private String adresssell;

	
	private String passwordsell;
	@Transient
private String otp;


	public String getOtp() {
	return otp;
}


public void setOtp(String otp) {
	this.otp = otp;
}


	public Integer getIdsell() {
		return idsell;
	}


	public void setIdsell(Integer idsell) {
		this.idsell = idsell;
	}


	public String getUsernamesell() {
		return usernamesell;
	}


	public void setUsernamesell(String usernamesell) {
		this.usernamesell = usernamesell;
	}


	public String getContactsell() {
		return contactsell;
	}


	public void setContactsell(String contactsell) {
		this.contactsell = contactsell;
	}


	public String getEmailsell() {
		return emailsell;
	}


	public void setEmailsell(String emailsell) {
		this.emailsell = emailsell;
	}


	public String getAdresssell() {
		return adresssell;
	}


	public void setAdresssell(String adresssell) {
		this.adresssell = adresssell;
	}


	public String getPasswordsell() {
		return passwordsell;
	}


	public void setPasswordsell(String passwordsell) {
		this.passwordsell = passwordsell;
	}


	@Override
	public String toString() {
		return "UserDtls [idsell=" + idsell + ", usernamesell=" + usernamesell + ", contactsell=" + contactsell
				+ ", emailsell=" + emailsell + ", adresssell=" + adresssell + ", passwordsell=" + passwordsell + "]";
	}


	public UserDtls(Integer idsell, String usernamesell, String contactsell, String emailsell, String adresssell,
			String passwordsell) {
		super();
		this.idsell = idsell;
		this.usernamesell = usernamesell;
		this.contactsell = contactsell;
		this.emailsell = emailsell;
		this.adresssell = adresssell;
		this.passwordsell = passwordsell;
	}


	public UserDtls() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}