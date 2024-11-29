package com.wastemanagement.e_wastemanagement.sellingService;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
import com.wastemanagement.e_wastemanagement.sellingentity.UserDtls;
import com.wastemanagement.e_wastemanagement.sellingerepository.sellingRepository;

@Service
public class sellingService {
	
	private sellingRepository reppsitory;
	private JavaMailSender javamailsender;
	
	
	public sellingService(sellingRepository reppsitory, JavaMailSender javamailsender) {
		this.reppsitory = reppsitory;
		this.javamailsender = javamailsender;
	}
	
	public UserDtls saveSelling(UserDtls user) {
		return reppsitory.save(user);
	}
	public boolean verifylogin(String username,String passsword) {
		List<UserDtls> all=reppsitory.findAll();
		for(UserDtls us:all) {
			if(us.getEmailsell().equals(username)&&us.getPasswordsell().equals(passsword)) {
				return  true;
			}
	}
		return false;}

}
