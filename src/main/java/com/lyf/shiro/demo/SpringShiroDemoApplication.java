package com.lyf.shiro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@SpringBootApplication
public class SpringShiroDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShiroDemoApplication.class, args);
	}

	@ResponseBody
	@RequestMapping({"/","/index"})
	public String index(){
		return "index";
	}
}
