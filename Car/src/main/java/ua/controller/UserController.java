package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ua.domain.request.RegistrationRequest;
import ua.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String registrationPage(Model model){
		model.addAttribute("user", new RegistrationRequest());
		return "registration";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("user") @Valid RegistrationRequest registrationRequest, BindingResult br){
		if(br.hasErrors()){
			return "registration";
		}
		userService.save(registrationRequest);
		return "redirect:/login";
	}
}
