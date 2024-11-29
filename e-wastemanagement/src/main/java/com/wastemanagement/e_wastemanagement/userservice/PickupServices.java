package com.wastemanagement.e_wastemanagement.userservice;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
import com.wastemanagement.e_wastemanagement.corprativeentity.PickupCorprater;
import com.wastemanagement.e_wastemanagement.entity.Pickup;
import com.wastemanagement.e_wastemanagement.entity.User;
import com.wastemanagement.e_wastemanagement.userrepository.PickupRepositoryuser;

@Service
public class PickupServices {

	
	private PickupRepositoryuser pickuprepository;

	public PickupServices(PickupRepositoryuser pickuprepository) {
		this.pickuprepository = pickuprepository;
	}
	
	public Pickup savePickup(Pickup pickup) {
		return pickuprepository.save(pickup);
		
	}
	
	public List<Pickup> getall(){
		return pickuprepository.findAll();
	}
	
//	public List<Pickup> getPickupPhotocorpertive(User user){
//		return (List<Pickup>) pickuprepository.findByUser(user);
//		
//	}
//}
}