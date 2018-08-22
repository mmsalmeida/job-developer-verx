package com.desafioverx.loginverx.repository;


import com.desafioverx.loginverx.model.Cliente;
import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;



public interface ClienteRepository extends JpaRepository<Cliente,Long>{
	
	
	Optional<Cliente> findById(Long Id);
 
	List<Cliente> findAll();

	//void flush();	
	


    @Modifying
    @Query(value = "insert into Cliente (nome,idade) VALUES (:nome,:idade)", nativeQuery = true)
    @Transactional
    void logURI(@Param("nome") String nome, @Param("idade") String idade);	
	
	
	
	
	/*@Modifying
	@Query("insert")
	public void insertCliente() {}
	*/
}
