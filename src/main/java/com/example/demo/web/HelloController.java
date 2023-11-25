package com.example.demo.web;

import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greet")
public class HelloController {
	@RequestMapping("/")
	public String sayHello() {
		return "<h1>Hello</h1><a href=\"/greet/user_entry\">Form</a>";
	}
	
	@RequestMapping("/basic")
	public String sayBasic() {
		return "<h1>Basic</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greet/user_greeting\" method=\"POST\">\r\n"
				+ "  <label for=\"fname\">First name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"fname\" name=\"firstname\"><br>\r\n"
				+ "  <label for=\"lname\">Last name:</label><br>\r\n"
				+ "  <input type=\"text\" id=\"lname\" name=\"lastname\"><br><br>\r\n"
				+ "  <input type=\"submit\" value=\"Submit\">\r\n"
				+ "</form> \r";
	}
	
	@RequestMapping(value = "/user_greeting", method = RequestMethod.POST)
	public String submitForm(@RequestParam String firstname, @RequestParam String lastname ) {
		return "<h2>Form Submitted</h2>" + firstname + " " + lastname;
	}
	
	@RequestMapping("/orders/{id}")
	public String getOrders(@PathVariable String id) {
		return "order id : " + id;
	}


	@RequestMapping("/orders/{userId}/invoices")
	public String getInvoices(@PathVariable int userId, @RequestParam(value="date", required=false) Date dateOrNull ) {
		return "invoice found for user : " + userId + " on " + dateOrNull;
	}
}

