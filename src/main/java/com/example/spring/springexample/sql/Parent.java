package com.example.spring.springexample.sql;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Parent {

	private String origin;

	public Parent(String origin) {
		this.origin = origin;
	}
}
