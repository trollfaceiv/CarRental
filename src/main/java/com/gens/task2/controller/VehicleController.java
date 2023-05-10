package com.gens.task2.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gens.task2.entities.Vehicle;
import com.gens.task2.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public String getVehicles(Model model) {
		List<Vehicle> vehicles = vehicleService.retrieveAll();
		model.addAttribute("Vehicles", vehicles);
		return "vehicles";
	}
	
	@RequestMapping(value = "/info/{vehicleid}", method = RequestMethod.GET)
	public String getVehicleInfo(@PathVariable("vehicleid") int vehicleId, Model model) {
		Vehicle v1 = vehicleService.selectVehicleByID(vehicleId);
		model.addAttribute("Titolo","Dettaglio veicolo");
		model.addAttribute("Titolo2", "Veicolo targato: " + v1.getPlateNumber());
		model.addAttribute("vehicle",v1);
		return "vehicleInfo";
	}
	
	@GetMapping(value= "/delete/{vehicleid}")
	public String deleteVehicle(@PathVariable("vehicleid") int vehicleId) {
		vehicleService.deleteItembyID(vehicleId);
		return "redirect:/vehicle/show";
	}
	@GetMapping(value = {"/add/{vehicleid}","/add/"})
	public String insertVehicle(Model model, @PathVariable(name="vehicleid",required = false) Integer vehicleId) {
		try {
			Vehicle v = vehicleService.selectVehicleByID(vehicleId);
			if(!v.getPlateNumber().isEmpty()) {
				model.addAttribute("Titolo","Dettaglio veicolo");
				model.addAttribute("Titolo2", "Veicolo targato: " + v.getPlateNumber());
				model.addAttribute("newVehicle",v);
				return "newVehicle";
			}
		}catch (Exception e) {
		}
		Vehicle v1 = new Vehicle();
		model.addAttribute("Titolo","Inserimento nuovo veicolo");
		model.addAttribute("newVehicle",v1);
		System.out.println("fine esecuzione della fase di GET");
		return "newVehicle";
	}
	
	@PostMapping(value = {"/add/{vehicleid}","/add/"})
	public String gestInsertVehicle(@ModelAttribute("newVehicle") @Valid Vehicle vehicle, @PathVariable(name="vehicleid",required = false) Integer vehicleId, BindingResult bindingResult, Model model){
		if(!isValid(vehicle.getPlateNumber())) {
	        model.addAttribute("error", "La targa non è nel formato italiano. Riprova.");
			return "newVehicle";
		}
		else {
			Vehicle v1 = vehicleService.selectVehicleByPlateNumber(vehicle.getPlateNumber());
			if(vehicleId == null) {
				if(v1 == null) {
					vehicleService.insertItem(vehicle);
				}
				else {
					model.addAttribute("error","Targa già presente, sei sicuro sia corretta?");
					return "newVehicle";
				}
			}
			else {
				if((v1 == null) || (v1 != null && v1.getId() == vehicleId.intValue())) {
					int newId = vehicleId.intValue();
					vehicle.setId(newId);
					vehicleService.insertItem(vehicle);
				}
				else {
					model.addAttribute("error","Hai inserito una targa appartenente ad un altro veicolo. Riprova.");
					return "newVehicle";
				}
			}
			}
		return "redirect:/vehicle/show";
		}
	
	
	public boolean isValid(String plateNumber) {
		String regex = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$";
		return plateNumber.matches(regex); 
	}
	
	
}

