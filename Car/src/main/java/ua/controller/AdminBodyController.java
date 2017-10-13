package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.Body;
import ua.service.BodyService;

@Controller
@RequestMapping("/admin/body")
@SessionAttributes("body")
public class AdminBodyController {

	private final BodyService service;

	@Autowired
	public AdminBodyController(BodyService service) {
		this.service = service;
	}
	
	@ModelAttribute("body")
	public Body getForm(){
		return new Body();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("bodies", service.findAll());
		return "body";
	}
	
	@PostMapping
	public String add(@ModelAttribute("body") @Valid Body body, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "body";
		}
		service.save(body);
		status.setComplete();
		return "redirect:/admin/body";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("body", service.findOne(id));
		show(model);
		return "body";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/body";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/body";
	}
}
