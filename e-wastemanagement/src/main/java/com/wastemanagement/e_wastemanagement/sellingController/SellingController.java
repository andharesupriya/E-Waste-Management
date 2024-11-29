package com.wastemanagement.e_wastemanagement.sellingController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wastemanagement.e_wastemanagement.entity.User;
import com.wastemanagement.e_wastemanagement.mailServisec.MailService;
import com.wastemanagement.e_wastemanagement.sellingService.sellingService;
import com.wastemanagement.e_wastemanagement.sellingentity.UserDtls;


@Controller
public class SellingController {
	private sellingService sellserver;
	private  MailService mailservice;

	public SellingController(sellingService sellserver,MailService mailservice) {
		super();
		this.sellserver = sellserver;
		this.mailservice=mailservice;
	}
	
	
	@GetMapping("/loginsell")
	public String sellingLogin(Model model) {
		return "registration";
		
	}
	
	String genraitedOtp;
	@PostMapping("/signupsell")
	public String showRegister(@ModelAttribute UserDtls user,Model model) {
		if(user.getOtp()==null) {
		genraitedOtp=mailservice.genraitOtp();
		mailservice.sendOtp(user.getEmailsell(), genraitedOtp);
		boolean isSend=true;
		if(isSend) {
			model.addAttribute("otpwindow","otp genraited");
		}
		return "registration";		
	}else {
		if(mailservice.verifyOtp(genraitedOtp,user.getOtp())) {
			model.addAttribute("susses","acount created");
			sellserver.saveSelling(user);
			return "redirect:/loginpagesell";
		}else {
			model.addAttribute("otpWindow","otp genraited");
			model.addAttribute("fail","Invalid otp ");
			return "registration";
		}
	}
		}
	
	@GetMapping("/loginpagesell")
	public String loginPage() {
		return "sellinglogin";
		
	}
	
	@PostMapping("/loginsell")
	public String validationLogin(Model model,@RequestParam("usernamesell") String username,@RequestParam("passwordsell") String password) {
		if(sellserver.verifylogin(username, password)) {
			return "selling";
		}
		else {
			model.addAttribute("error","Invalid username and password");
		return "sellinglogin";
		}
	} 
	@GetMapping("/q")
	public String buyp() {
		return "buy";
	}
	@GetMapping("/about")
	public String aboutus() {
		return "aboutUs";
		
		
	}
	
	@GetMapping("/contact")
	public String ContactUs() {
		return "contactUs";
		
		
	}

}
