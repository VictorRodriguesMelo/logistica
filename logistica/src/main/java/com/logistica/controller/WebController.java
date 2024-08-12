package com.logistica.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/web")
public class WebController {
	
		@GetMapping("/home")
		public String home(Model model) {
	        model.addAttribute("mensagem", "Bem-vindo à página web renderizada com Thymeleaf!");

	        return "home";
	    }
	}
