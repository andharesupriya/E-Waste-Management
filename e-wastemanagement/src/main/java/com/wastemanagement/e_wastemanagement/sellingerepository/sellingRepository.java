package com.wastemanagement.e_wastemanagement.sellingerepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wastemanagement.e_wastemanagement.sellingentity.UserDtls;
@Repository
public interface sellingRepository extends JpaRepository<UserDtls,Integer>{

}
