package com.example.spring.springexample.controllers;

import com.example.spring.springexample.models.Clean;
import com.example.spring.springexample.models.Person;
import com.example.spring.springexample.services.ComplexService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Controller
@RequestMapping("")
@PropertySource("classpath:application_pl.properties")
//@ConfigurationProperties("app")
public class ComplexController {

	final
	Person person;

	final
	ComplexService service;

	private List<Clean> cleans = new ArrayList<>();

	@Autowired
	public ComplexController(ComplexService service, Person person) {
		this.service = service;
		this.person = person;
	}

//	@GetMapping("/complex")
//	public List<Complex> getComplex() {
//		return service.getComplex();
//	}
//
//	@PostMapping("/complex")
//	public void addComplex(@RequestBody Complex complex) {
//		service.save(complex);
//	}
//
//	@GetMapping("/c1")
//	public String getSingleComplex() {
//		return service.getSingleComplex("Williams");
//	}
//
//	@GetMapping("/t1")
//	public String getTh1(Model model) {
//		model.addAttribute("title", "homie");
//		return "home";
//	}
//
//	@GetMapping("/t2")
//	public String getTh2(Model model) {
//		model.addAttribute("title", "homie");
//		Map<String, String> map = new HashMap<>();
//		map.put("mapka", "mapkaValue");
//		map.put("mapka2", "mapkaValue2");
//		model.mergeAttributes(map);
//		return "home";
//	}
//
//	@GetMapping("/t3")
//	public String passParametersWithModelMap(ModelMap map) {
//		map.addAttribute("welcome1", "welcome");
//		map.addAttribute("welcome2", "Baeldung");
//		return "home";
//	}
//
//	@GetMapping("/t4")
//	public String passParametersWithModelMap(Model model) {
//		model.addAttribute("clean", new Clean("elo ziemo"));
//		model.addAttribute("person", person);
//		return "home";
//	}

//	@GetMapping("/t55")
//	public String passParametersWithModelMapsd(@ModelAttribute Clean clean) {
//		return "formik";
//	}

//	@PostMapping("/t55")
//	public String th5() {
//		System.out.println(clean.getName());
//		model.addAttribute("clean", clean.getName());
//		return "home";
//	}


	@GetMapping("/form")
	public String getForm(Clean clean) {
		return "formik";
	}

	@PostMapping("/form")
	public String getWelcomePage(Model model, Clean clean) {
		model.addAttribute("title", "home");
		model.addAttribute(clean);
		return "home";
	}

//	@GetMapping("/no")
//	public String fromObject(Model model) {
//		model.addAttribute("clean", new Clean("ziemeczek"));
//		return "home";
//	}


	@GetMapping("/t1")
	public String t1(ModelMap model) {
		model.addAttribute("title", "starter");
		model.addAttribute("name", "zizi");
		model.addAttribute("summary1", "wtf!");

		List<Clean> cleans = new ArrayList<>();
		cleans.add(new Clean("one"));
		cleans.add(new Clean("two"));
		cleans.add(new Clean("three"));
		model.addAttribute("cleans", cleans);

		Map<String, String> mapka = new HashMap<>();
		mapka.put("name", "imie");
		mapka.put("age", "100");
		model.addAttribute("mapka", mapka);
		return "home";
	}

	@GetMapping("/cleans")
	@ResponseBody
	public List<Clean> getCleans() {
		return cleans;
	}


	@GetMapping("/ss")
	public void getCleans(@Value("${app.start}") String start, HttpServletResponse response) throws IOException {
		response.getWriter().write(start);
	}


}
