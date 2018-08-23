package com.desafioverx.loginverx.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioverx.loginverx.model.Cliente;



public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	
	Optional<Cliente> findById(Long Id);
 
	List<Cliente> findAll();
	
	

	
}
