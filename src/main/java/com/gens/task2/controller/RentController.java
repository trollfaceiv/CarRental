package com.gens.task2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gens.task2.entities.Rent;
import com.gens.task2.entities.User;
import com.gens.task2.entities.Vehicle;
import com.gens.task2.service.RentService;
import com.gens.task2.service.UserService;
import com.gens.task2.service.VehicleService;

@Controller
@RequestMapping("/rent")
public class RentController {
	
	@Autowired
	private RentService rentService;
	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private UserService userService;
	
	//@PathVariable("userid") int userId, @PathVariable("vehicleid") int vehicleId, 
	
	
	
	
	@GetMapping(value = "/show")
	public String showRents(Model model) {
		List<Rent> list = rentService.retrieveAll();
		model.addAttribute("rents",list);
		return "rents";
	}
	
	@RequestMapping(value = "/{userid}/new/{vehicleid}", method = RequestMethod.GET)
	public String rentCar(Model model) {
		Rent r1 = new Rent();
		model.addAttribute("Titolo","creazione prenotazione");
		model.addAttribute("Titolo","Sei a un passo dal noleggiare l'auto!");
		model.addAttribute("rent",r1);
		return "newRent";
	}
	
	@RequestMapping(value = "/{userid}/new/{vehicleid}", method = RequestMethod.POST)
	public String gestRentCar(@ModelAttribute("rent") Rent r1, @PathVariable("vehicleid") int vehicleId, @PathVariable("userid") int userId, Model model) {
		Vehicle v1 = vehicleService.selectVehicleByID(vehicleId);
		r1.setVehicle(v1);
		r1.setUser(userService.retrieveByID(userId));
		r1.setApproved("In sospeso");
		v1.setAvaible(false);
		vehicleService.insertItem(v1);
		rentService.insertItem(r1);
		return "redirect:/vehicle/show";
	}
	
	@GetMapping(value = "/delete/{rentid}")
	public String deleteRent(@PathVariable("rentid") int rentId, HttpServletRequest request) {
		Rent r1 = rentService.retrieveByID(rentId);
		User user = rentService.retrieveUserByRentID(rentId);
		Vehicle vehicle = vehicleService.selectVehicleByID(r1.getVehicle().getId());
		try {
			rentService.deleteItem(r1);
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}
	
	@GetMapping(value = "/approve/{rentid}")
	public String approveRent(@PathVariable("rentid") int rentId, HttpServletRequest request) {
		Rent r1 = rentService.retrieveByID(rentId);
		r1.setApproved("Approvato");
		rentService.insertItem(r1);
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}
	
	@GetMapping(value = "/refuse/{rentid}")
	public String refuseRent(@PathVariable("rentid") int rentId, HttpServletRequest request) {
		Rent r1 = rentService.retrieveByID(rentId);
		r1.setApproved("Rifiutato");
		rentService.insertItem(r1);
		String referer = request.getHeader("Referer");
	    return "redirect:" + referer;
	}
}
