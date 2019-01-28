package com.example.spring.springexample.services;

import com.example.spring.springexample.models.Complex;
import com.example.spring.springexample.repositories.ComplexRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplexService {

	final
	ComplexRepo repo;

	@Autowired
	public ComplexService(ComplexRepo repo) {
		this.repo = repo;
	}

	public List<Complex> getComplex() {
		return repo.getComplex();
	}

	public void save(Complex complex) {
		repo.save(complex);
	}

	public String getSingleComplex(String name) {
		return repo.getComplexByName(name);
	}


}
