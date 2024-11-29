package com.wastemanagement.e_wastemanagement.corparativeServicee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wastemanagement.e_wastemanagement.corprativeRepository.CorpartiveRepository;
import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
import com.wastemanagement.e_wastemanagement.entity.User;

@Service
public class CorprativeService {

	
	private CorpartiveRepository corapartiverepository;
	
	public CorprativeService(CorpartiveRepository corapartiverepository) {
		this.corapartiverepository=corapartiverepository;	
	}
	
	public Corprative saveCorprative(Corprative corprative) {
		return corapartiverepository.save(corprative);
	}
	
	public boolean verifylogin(String username,String passsword) {
		List<Corprative> all=corapartiverepository.findAll();
		for(Corprative us:all) {
			if(us.getEmail().equals(username)&&us.getPassword().equals(passsword)) {
				return  true;
			}
	}
		return false;
	}
	//pickup
	
	
}
