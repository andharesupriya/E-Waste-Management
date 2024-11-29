package com.wastemanagement.e_wastemanagement.userservice;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wastemanagement.e_wastemanagement.entity.Pickup;
import com.wastemanagement.e_wastemanagement.entity.User;
import com.wastemanagement.e_wastemanagement.userrepository.UserRepository1;

@Service
public class UserService {
	
	private UserRepository1 userrepository;
	
	public UserService(UserRepository1 userrepository) {
		this.userrepository=userrepository;
	}
	
	public User saveUser(User user) {
		return userrepository.save(user);
		
	}
	
	public boolean verifylogin(String username,String passsword) {
		List<User> all=userrepository.findAll();
		for(User us:all) {
			if(us.getUsername().equals(username)&&us.getPassword().equals(passsword)) {
				return  true;
			}
	}
		return false;
	}
	
	
	//uplode photo
//	Pickup pickup;
//	public void saveProfilehoto(byte[]  photo,String username) {
//		User user=userrepository.findByUserName(username);
//		
//		pickup.setPhoto(photo);
//		userrepository.save(user);
//		
//	}
	
	public User findByUsername(int id) {
return 	userrepository.findById(id).orElse(null);
}
	

}
