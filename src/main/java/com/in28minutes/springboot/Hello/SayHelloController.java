package com.in28minutes.springboot.Hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-Hello")
	@ResponseBody
	public String sayHello() {
		return "Hello, How are you!";
	}
	
	@RequestMapping("say-Hello-HTML")
	@ResponseBody
	public String sayHelloHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My Html page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first HTML page body");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("say-Hello-JSP")
	//@ResponseBody
	public String sayHelloJSP() {
		return "sayHello";
	}
}
