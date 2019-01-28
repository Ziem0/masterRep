package com.example.spring.springexample.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Complex {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private int budget;

	@Column(unique = true)
	private String driver;

	public Complex(String name, int budget, String driver) {
		this.name = name;
		this.budget = budget;
		this.driver = driver;
	}

	public Complex() {
	}
}
