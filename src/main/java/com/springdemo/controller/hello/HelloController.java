package com.springdemo.controller.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	private MessageSource messageSource; 
	
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
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name= "Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	
}
