package com.example.spring.springexample.controllers;

import com.example.spring.springexample.models.NameOne;
import com.example.spring.springexample.models.Person;
import com.example.spring.springexample.models.Worker;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Controller
@RequestMapping("/")
//@PropertySource("classpath:application_pl.properties")
//@ConfigurationProperties("my")
public class PersonController {

	private List<Person> persons = new ArrayList<>();

	final
	Person person;

	final
	Worker worker;

	@Autowired
	public PersonController(Person person, Worker worker) {
		this.person = person;
		this.worker = worker;
	}


	@GetMapping("/start")
	public void getName(HttpServletResponse response) throws IOException {
		response.getWriter().write(person.getName().getN());
	}

	@GetMapping("/worker")
	public void getWorker(HttpServletResponse response) throws IOException {
		response.getWriter().write(worker.getName().getName().getN());
	}

	@GetMapping("/param")
	public void getParam(@RequestParam String age, HttpServletResponse response) throws IOException {
		response.getWriter().write(age);
	}

	@GetMapping("/head")
	public void getHead(@RequestHeader String host, HttpServletResponse response) throws IOException {
		response.getWriter().write(host);
	}

	@GetMapping("/pv/{name}")
	public void getPV(@PathVariable(name = "name") String name, HttpServletResponse response) throws IOException {
		response.getWriter().write(name);
	}

	@PostMapping("/rb")
	public void getRB(@RequestBody NameOne name, HttpServletResponse response) throws IOException {
		response.getWriter().write(name.getN());
	}

	@GetMapping("/session")
	public void getSession(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setMaxInactiveInterval(-1);
	}

	@GetMapping("/prop")
	public void getFromProp(HttpServletResponse response, @Value("${myConfigReader.welcome}") String name) throws IOException {
		response.getWriter().write(name);
	}

	@GetMapping("/prop2") // returns char!
	public void getFromProp2(HttpServletResponse response, @Value("${myConfigReader.num}") Integer num) throws IOException {
		response.getWriter().write(num);
	}

	@GetMapping("/prop3")
	public void getFromProp3(HttpServletResponse response, @Value("${ziemoConf.value}") String value) throws IOException {
		response.getWriter().write(value);
	}

	@GetMapping("/prop4")
	public void getFromProp4(HttpServletResponse response, @Value("${ziemoConf.lista}") String[] list) throws IOException {
		Arrays.stream(list).forEach(System.out::println);
		response.getWriter().write("ok");
	}

	@GetMapping("/showP1")
	@ResponseBody
	public List<Person> getPersons() {
		return persons;
	}

}
