package com.example.spring.springexample.sql;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class T2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String color;

	public T2(String color) {
		this.color = color;
	}

	public T2() {
	}



}
