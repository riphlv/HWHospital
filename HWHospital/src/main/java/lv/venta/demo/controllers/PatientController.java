package lv.venta.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.models.Patient;
import lv.venta.demo.services.impl.DataFilterImpl;
import lv.venta.demo.services.impl.DataInputImpl;

@Controller
@RequestMapping("/patient")
public class PatientController {
	@Autowired 
	DataFilterImpl dataFilterImpl;
	@Autowired
	DataInputImpl dataInputImpl;
	////////////////////////////////////////
	@GetMapping("/showAllDoctors")
	public String showAllDoctors(Model model) {
		model.addAttribute("innerObj",dataFilterImpl.selectAllDoctors());
		return "all-doctors-show";
	}
	@GetMapping("/register")
	public String insertNewPatient(Patient patient) {
		return "register-patient";
	}
	@PostMapping("/register")
	public String insertPost(@Valid Patient patient, BindingResult result) {
		if(!result.hasErrors()) {
			dataInputImpl.insertPatient(patient);
			//return "redirect:/ok";
			return "ok";
		}
		return "register-patient";
	}
	////////////////////////////////////////
}
