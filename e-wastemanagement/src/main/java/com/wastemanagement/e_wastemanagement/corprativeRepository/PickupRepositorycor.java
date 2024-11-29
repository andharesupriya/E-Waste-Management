package com.wastemanagement.e_wastemanagement.corprativeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
import com.wastemanagement.e_wastemanagement.corprativeentity.PickupCorprater;
import com.wastemanagement.e_wastemanagement.entity.Pickup;

@Repository
public interface PickupRepositorycor extends JpaRepository<PickupCorprater,Integer> {

	//PickupCorprater save(PickupCorprater pp);
}
