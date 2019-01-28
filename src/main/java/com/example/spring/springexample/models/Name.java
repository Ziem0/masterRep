package com.example.spring.springexample.models;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class Name {

	private	String n;

	public Name(String n) {
		this.n = n;
	}

}
