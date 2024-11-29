package com.wastemanagement.e_wastemanagement.corparativeServicee;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wastemanagement.e_wastemanagement.corprativeRepository.CorpartiveRepository;
import com.wastemanagement.e_wastemanagement.corprativeRepository.PickupRepositorycor;
import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
import com.wastemanagement.e_wastemanagement.corprativeentity.PickupCorprater;
import com.wastemanagement.e_wastemanagement.entity.Pickup;
import com.wastemanagement.e_wastemanagement.entity.User;

@Service
public class PickupServiceOfCorprative {

	private PickupRepositorycor pickup;

	public PickupServiceOfCorprative(PickupRepositorycor pickup) {
		this.pickup = pickup;
	}
	
	public PickupCorprater savePi(PickupCorprater ppcor) {
		return pickup.save(ppcor);
		
		}
	

}
