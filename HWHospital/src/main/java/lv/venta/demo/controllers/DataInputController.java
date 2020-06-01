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
import lv.venta.demo.models.Patient;
import lv.venta.demo.services.impl.DataFilterImpl;
import lv.venta.demo.services.impl.DataInputImpl;

@Controller
@RequestMapping("/input")
public class DataInputController {
	//Services implementation
	@Autowired 
	DataInputImpl dataInputImpl;
	
	/*
	@Autowired
	DataFilterImpl dataFilterImpl;
	*/
	//Administrator controller
	@GetMapping(value="/admin/inputdata")
	public String inputData() {
		dataInputImpl.inputData();
		return "input";
	}
	//Patient controller
	@GetMapping(value="/patient/register")
	public String insertNewPatient(Patient patient) {
		return "register-patient";
	}
	@PostMapping("/patient/register")
	public String insertPost(@Valid Patient patient, BindingResult result) { //aizpildits obj
		if(!result.hasErrors()) {
			dataInputImpl.insertPatient(patient);
			return "redirect:/";
		}
		return "register-patient";
	}
	@GetMapping(value="/admin/updatePatientById")
	public String updatePatientById(Model model, Patient patient) {
		dataInputImpl.updatePatientById(patient.getUser_id(), patient);
		return "update-patient";
	}
	@PostMapping("/admin/updatePatientById")
	public String updatePatientById(Patient patient) { //aizpildits obj
		//TODO IF
		dataInputImpl.insertPatient(patient);
		return "redirect:/";
	}
	/* TODO CHECK ERROR
	 * Field dataFilterImpl in lv.venta.demo.controllers.DataInputController
	 * required a bean of type 'lv.venta.demo.services.impl.DataFilterImpl'
	 * that could not be found.
	@GetMapping(value="/admin/deletePatientById/{id}")
	public String deletePatientById(@PathVariable(name="id") int id, Model model) {
		if(dataInputImpl.deletePatientById(id)) {
			model.addAttribute("innerObj",dataFilterImpl.selectAllPatients());
			return "all-patients-show";
		}else {
			return "redirect:/";
		}
	}*/
	@GetMapping(value="/doctor/register")
	public String insertNewDoctor(Doctor doctor) {
		return "register-doctor";
	}
	@PostMapping("/doctor/register")
	public String insertPost(@Valid Doctor doctor, BindingResult result) { //aizpildits obj
		if(!result.hasErrors()) {
			dataInputImpl.insertDoctor(doctor);
			return "redirect:/";
		}
		return "register-doctor";
	}
//	@GetMapping(value="/user/authorise")
//	public String authoriseUser(User user) {
//		
//	}
	
}
