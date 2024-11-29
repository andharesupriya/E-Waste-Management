package com.wastemanagement.e_wastemanagement.corprativemail;

import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.wastemanagement.e_wastemanagement.corprativeRepository.CorpartiveRepository;

@Service
public class CorprativeMailServices {

private JavaMailSender javamailsender;
	
	public CorprativeMailServices (JavaMailSender javamailsender)
	{
		this.javamailsender=javamailsender;
		
	}
	
	public String genraitOtp() {
		Random rn=new Random();
		int next=rn.nextInt(999999);
		String otp=Integer.toString(next);
		System.out.println(otp);
		return otp;
	}
	
	public void sendOtp(String mail,String otp) {
		SimpleMailMessage msg= new  SimpleMailMessage();
		msg.setTo(mail);
		msg.setSubject("E waste mangement team");
		msg.setText("otp from e waste managemenr team"+otp);
		javamailsender.send(msg);
	}
	
	
	public boolean verifyOtp(String genraitedOtp,String enteredOtp) {
		if(genraitedOtp.equals(enteredOtp)) {
			return true;
		}
		else {
		return false;
		
	}
}
	

}
