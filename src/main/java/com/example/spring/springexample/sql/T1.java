package com.example.spring.springexample.sql;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class T1 extends Parent{

	private String name;
	private int age;

	public T1(String origin, String name, int age) {
		super(origin);
		this.name = name;
		this.age = age;
	}


	public static void main(String[] args) {
		List<Parent> parents = new ArrayList<>();
		Parent parent = new T1("Leszno", "ziemo", 34);
		T1 kid = new T1("Krakow", "ziemo", 34);

		T1 t1 = new T1("Poznan", "nina", 26);
//		T1 t2 = (T1) new Parent("Wroclaw");

		parents.add(parent);
		parents.add(kid);
		parents.add(t1);

		System.out.println(((T1) parent).age);

		parents.forEach(e -> System.out.println(e.getOrigin()));
	}
}
