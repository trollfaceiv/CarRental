package com.gens.task2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gens.task2.entities.Rent;
import com.gens.task2.entities.User;
import com.gens.task2.entities.Vehicle;
import com.gens.task2.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/info/{userid}", method = RequestMethod.GET)
	public String getUserByID(@PathVariable("userid") int userId, Model model, HttpServletRequest request) {
		User user = userService.retrieveByID(userId);
		List<Rent> rents = user.getRents();
		model.addAttribute("user", user);
		model.addAttribute("rents", rents);
		return "userinfo";
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getAllUsers(Model model) {
		List <User> list = userService.retrieveAll();
		model.addAttribute("users", list);
		return "users";
	}
	
	@GetMapping(value = "/add")
	public String insertUser(Model model) {
		User user = new User();
		
		model.addAttribute("Titolo","Inserimento nuovo utente");
		model.addAttribute("newUser",user);
		return "newUser";
	}
	
	@PostMapping(value = "/add")
	public String gestInsertUser(@ModelAttribute("newUser") User user, Model model) {
		System.out.println("aggiunto");
		   User existingUser = userService.selectByUserName(user.getUserName());
		    if (existingUser != null) {
		        model.addAttribute("registrationError", "Username già esistente");
		        return "newUser";
		    }
		    
		
			userService.insertItem(user);
		
		return "redirect:/user/show";
	}
}
