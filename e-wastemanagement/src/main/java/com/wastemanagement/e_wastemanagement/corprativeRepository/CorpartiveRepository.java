package com.wastemanagement.e_wastemanagement.corprativeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wastemanagement.e_wastemanagement.corprativeentity.Corprative;
@Repository
public interface CorpartiveRepository extends JpaRepository<Corprative,Integer> {

}
