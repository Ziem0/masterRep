package com.example.spring.springexample.models;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class Worker {

	@Autowired
	Person name;


}
