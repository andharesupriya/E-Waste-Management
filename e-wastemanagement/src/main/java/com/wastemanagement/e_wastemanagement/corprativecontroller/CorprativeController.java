package com.wastemanagement.e_wastemanagement.corprativecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wastemanagement.e_wastemanagement.corparativeServicee.CorprativeService;
import com.wastemanagement.e_wastemanagement.corparativeServicee.PickupServiceOfCorprative;
import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
import com.wastemanagement.e_wastemanagement.corprativeentity.PickupCorprater;
import com.wastemanagement.e_wastemanagement.corprativemail.CorprativeMailServices;
import com.wastemanagement.e_wastemanagement.entity.Pickup;
import com.wastemanagement.e_wastemanagement.entity.User;


@Controller
public class CorprativeController {

	private CorprativeService corprativeservice;
	private CorprativeMailServices corprativemailservice;
	private PickupServiceOfCorprative pickupser;

	public CorprativeController(CorprativeService corprativeservice, CorprativeMailServices corprativemailservice,PickupServiceOfCorprative pickupser) {
		this.corprativeservice = corprativeservice;
		this.corprativemailservice = corprativemailservice;
		this.pickupser=pickupser;
	}
	
	@GetMapping("/corprative")
	public String corprativeRegister(Model model) {
		model.addAttribute("corsignup",new Corprative());
		return "corprativeRegistration";
		
	} 
	
	String genraitedOtp;
	@PostMapping("/signupcor")
	public String showRegister(@ModelAttribute Corprative corpertive,Model model) {
		if(corpertive.getOtp()==null) {
		genraitedOtp=corprativemailservice.genraitOtp();
		corprativemailservice.sendOtp(corpertive.getEmail(), genraitedOtp);
		boolean isSend=true;
		if(isSend) {
			model.addAttribute("otpwindow","otp genraited");
		}
		return "corprativeRegistration";		
	}else {
		if(corprativemailservice.verifyOtp(genraitedOtp,corpertive.getOtp())) {
			model.addAttribute("susses","acount created");
			corprativeservice.saveCorprative(corpertive);
			return "redirect:/e";
		}else {
			model.addAttribute("otpWindow","otp genraited");
			model.addAttribute("fail","Invalid otp ");
			return "corprativeRegistration";
		}
	}
		}
	@GetMapping("/e")
	public String setLogin() {
		return "corLogin";
		
	}
	@PostMapping("/logincor")
	public String getLogin(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		if(corprativeservice.verifylogin(username, password)) {
			return "pickup";
		}
		else {
			model.addAttribute("error","Invalid username and password");
		return "corLogin";
		}
	}

//pictre uplode
	
	@GetMapping("/po")
public String showta(Model model) {
		model.addAttribute("ppickupobj",new PickupCorprater());
	return "pickupcor";
	
}
	@PostMapping("/pickupformcor")
	public String Showdat(@ModelAttribute PickupCorprater pickup) {
		pickupser.savePi(pickup);
		return "done";
		}

	
}
