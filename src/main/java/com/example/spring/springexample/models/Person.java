package com.example.spring.springexample.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {

	final
	Name name;

	@Autowired
	public Person(Name name) {
		this.name = name;
	}
}
