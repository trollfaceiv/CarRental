package com.gens.task2.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gens.task2.entities.User;
import com.gens.task2.service.UserService;


@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "index")
	public String getWelcome(Principal principal, Model model) {
		try{
			if(!principal.getName().isEmpty()) {
				User us1 = userService.selectByUserName(principal.getName());
				model.addAttribute("userLog",us1);
				model.addAttribute("intestazione","Ciao "+principal.getName());
				model.addAttribute("saluti","Seleziona l'auto da noleggiare");
				return "index";
				}
		}catch(Exception e) {
			e.printStackTrace();
			}
	
			model.addAttribute("intestazione","Benvenuti nel sito di Car Rental");
			model.addAttribute("saluti","Fai l'accesso e seleziona l'auto da noleggiare");
				
			return "index";

	
	}
	
	
	@RequestMapping
	public String getWelcome2(Principal principal, Model model) {
		return "redirect:/index";
	}
	}
	

