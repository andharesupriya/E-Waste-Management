package com.wastemanagement.e_wastemanagement.userrepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wastemanagement.e_wastemanagement.entity.Pickup;
import com.wastemanagement.e_wastemanagement.entity.User;
@Repository
public interface UserRepository1 extends JpaRepository<User,Integer>{

	 // User findByUserNameint (int id);
}
