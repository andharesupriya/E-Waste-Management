package com.wastemanagement.e_wastemanagement.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wastemanagement.e_wastemanagement.entity.Pickup;
import com.wastemanagement.e_wastemanagement.entity.User;
import com.wastemanagement.e_wastemanagement.mailServisec.MailService;
import com.wastemanagement.e_wastemanagement.userservice.PickupServices;
import com.wastemanagement.e_wastemanagement.userservice.UserService;

@Controller
public class UserController {
	
	private UserService userservice;
	private MailService mailservice;
	private PickupServices pickupservice;
	
	
	public UserController(UserService userservice, MailService mailservice,PickupServices pickupservice) {
		this.userservice = userservice;
		this.mailservice = mailservice;
		this.pickupservice=pickupservice;
		
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user",new User());
		return "signup";
		
	}
	
	String genraitedOtp;
	@PostMapping("/signup")
	public String showRegister(@ModelAttribute User user,Model model) {
		if(user.getOtp()==null) {
		genraitedOtp=mailservice.genraitOtp();
		mailservice.sendOtp(user.getEmail(), genraitedOtp);
		boolean isSend=true;
		if(isSend) {
			model.addAttribute("otpwindow","otp genraited");
		}
		return "signup";		
	}else {
		if(mailservice.verifyOtp(genraitedOtp,user.getOtp())) {
			model.addAttribute("susses","acount created");
			userservice.saveUser(user);
			return "redirect:/loginpage";
		}else {
			model.addAttribute("otpWindow","otp genraited");
			model.addAttribute("fail","Invalid otp ");
			return "signup";
		}
	}
		}
	
	
	@GetMapping("/loginpage")
	public String loginPage() {
		return "login";
		
	}
	
	@PostMapping("/login")
	public String validationLogin(Model model,@RequestParam() String username,@RequestParam() String password) {
		if(userservice.verifylogin(username, password)) {
			return "pickup";
		}
		else {
			model.addAttribute("error","Invalid username and password");
		return "login";
		}
	}
	//Pickup
	@GetMapping("/p")
	public String showProduct(Model model) {
	model.addAttribute("pickupobj", new Pickup());
	return "pickup";
	
}
@PostMapping("/pickupform")
public String createProduct(@ModelAttribute Pickup pickup,byte[] file) {
	pickupservice.savePickup(pickup);
	return "done";

}	

//home
//@GetMapping("/")
//public String show() {
//	return "home";
//	}

	

}
