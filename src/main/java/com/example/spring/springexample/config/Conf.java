package com.example.spring.springexample.config;

import com.example.spring.springexample.models.Name;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Conf {

	@Bean
	public Name getN() {
		return new Name("ziemo");
	}

	@Bean
	@Primary
	public Name getN2() {
		return new Name("ola");
	}


}
