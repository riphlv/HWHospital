package lv.venta.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.demo.models.User;
import lv.venta.demo.services.impl.DataFilterImpl;
import lv.venta.demo.services.impl.DataInputImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired 
	DataFilterImpl dataFilterImpl;
	@Autowired
	DataInputImpl dataInputImpl;
	////////////////////////////////////////
	@GetMapping("/authorise")
	public String authoriseUser(User user) {
		return "user-authorise";
	}
	@PostMapping("/authorise")
	public String authoriseUserPost(@Valid User user, BindingResult result) {
		if(!result.hasErrors()) {
			dataInputImpl.authoriseUser(user);
		}
		return "ok";
		
	}
}
