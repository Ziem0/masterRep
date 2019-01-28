package com.example.spring.springexample.repositories;

import com.example.spring.springexample.models.Complex;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplexRepo extends CrudRepository<Complex, Integer> {

	@Query("select c from Complex c")
	List<Complex> getComplex();

	@Query(value = "select c.driver from complex c where c.name=?1", nativeQuery = true)
	String getComplexByName(String name);


}
