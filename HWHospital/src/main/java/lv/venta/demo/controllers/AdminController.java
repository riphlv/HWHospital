package lv.venta.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.models.Patient;
import lv.venta.demo.services.impl.DataFilterImpl;
import lv.venta.demo.services.impl.DataInputImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired 
	DataFilterImpl dataFilterImpl;
	@Autowired
	DataInputImpl dataInputImpl;
	////////////////////////////////////////
	@GetMapping("/inputdata")
	public String inputData() {
		dataInputImpl.inputData();
		return "ok";
	}
	@GetMapping(value="/updatePatientById/{user_id}")
	public String updatePatientById(@PathVariable(name="user_id") int user_id,Model model, Patient patient) {
		try {
			Patient temp = dataInputImpl.updatePatientById(user_id);
			model.addAttribute("patient",temp);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "patient-update";
	}
	@PostMapping("/updatePatientById")
	public String updatePatientById(Patient patient) {
		dataInputImpl.updatePatientByObject(patient);
		return "ok";
	}
	@GetMapping(value="/deletePatientById/{user_id}")
	public String deletePatientById(@PathVariable(name="user_id") int user_id, Model model) {
		if(dataInputImpl.deletePatientById(user_id)) {
			model.addAttribute("innerObj",dataFilterImpl.selectAllPatients());
			return "all-patients-show";
		}else {
			return "error";
		}
	}
}
