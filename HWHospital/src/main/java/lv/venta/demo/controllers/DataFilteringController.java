package lv.venta.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.enums.Speciality;
import lv.venta.demo.services.impl.DataFilterImpl;

//@Controller
@RequestMapping("/filter")
public class DataFilteringController {
	//Service impl
	@Autowired 
	DataFilterImpl dataFilterImpl;
	//Filters
	@GetMapping(value="/patient/showAllDoctors")
	public String showAllDoctors(Model model) {
		model.addAttribute("innerObj",dataFilterImpl.selectAllDoctors());
		return "all-doctors-show";
	}
	
	@GetMapping(value="patient/showAllDoctorsByType/{speciality}")
	public String showAllDoctorsByType(Model model,@PathVariable(name="speciality") Speciality speciality) {
		try {
			dataFilterImpl.selectAllDoctorsByType(speciality);
			return "all-doctors-by-type";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
		
	}
	/*
	@GetMapping(name="/showAllPatients")
	public String showAllPatients(Model model) {
		model.addAttribute("innerObj",dataFilterImpl.selectAllPatients());
		return "all-patients-show";
	}
	*/
	@GetMapping(name="/doctors/selectPatientByNameAndSurname/{name}{surname}")
	public String selectPatientByNameAndSurname(Model model,@PathVariable(name="name") String name, @PathVariable(name="surname") String surname) {
		try {
			model.addAttribute("innerObj",dataFilterImpl.selectAllPatientsByNameAndSurname(name, surname));
			return "patient-show";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	//TODO SELECT APPOINTMENTS
	
	
	
}
