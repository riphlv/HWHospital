package lv.venta.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.models.Doctor;
import lv.venta.demo.services.impl.DataFilterImpl;
import lv.venta.demo.services.impl.DataInputImpl;

@Controller
@RequestMapping("/doctor")
public class DoctorsController {
	@Autowired 
	DataFilterImpl dataFilterImpl;
	@Autowired
	DataInputImpl dataInputImpl;
	////////////////////////////////////////
	@GetMapping("/showAllPatients")
	public String showAllDoctors(Model model) {
		model.addAttribute("innerObj",dataFilterImpl.selectAllPatients());
		return "all-patients-show";
	}
	@GetMapping("/selectPatientByNameAndSurname/{name}/{surname}")
	public String selectPatientByNameAndSurname(Model model,@PathVariable String name, @PathVariable String surname) {
		try {
			model.addAttribute("innerObj",dataFilterImpl.selectAllPatientsByNameAndSurname(name, surname));
			return "patient-one-show";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error";
	}
	@GetMapping("/register")
	public String insertNewDoctor(Doctor doctor) {
		return "register-doctor";
	}
	@PostMapping("/register")
	public String insertPost(@Valid Doctor doctor, BindingResult result) {
		if(!result.hasErrors()) {
			dataInputImpl.insertDoctor(doctor);
			//return "redirect:/";
			return "ok";
		}
		return "register-doctor";
	}
}
