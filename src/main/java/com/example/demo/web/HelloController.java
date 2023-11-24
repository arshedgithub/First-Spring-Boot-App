package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greet")
public class HelloController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sayHello() {
		return "<h1>Hello</h1>";
	}
	@RequestMapping(value = "/basic", method = RequestMethod.GET)
	public String sayBasic() {
		return "<h1>Basic</h1>";
	}
}

