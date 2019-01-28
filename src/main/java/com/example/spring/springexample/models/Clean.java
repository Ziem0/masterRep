package com.example.spring.springexample.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clean {

	private String name;

	public Clean(String name) {
		this.name = name;
	}
}
