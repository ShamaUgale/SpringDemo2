package com.springdemo.controller.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(path="/hello")
	public String helloWorld(){
		return "Hello  World !!";
	}
	
	@GetMapping(path="/hello/{name}")
	public String hello(@PathVariable String name){
		return String.format("%s", "Hello  World !! " + name);
	}
	
	@GetMapping(path="/helloBean/{name}")
	public HelloBean helloBean(@PathVariable String name){
		return new HelloBean("Hello " + name);
	}
	
	
}
