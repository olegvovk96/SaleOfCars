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

import ua.entity.Comfort;
import ua.service.ComfortService;

@Controller
@RequestMapping("/admin/comfort")
@SessionAttributes("comfort")
public class AdminComfortController {

	private final ComfortService service;

	@Autowired
	public AdminComfortController(ComfortService service) {
		this.service = service;
	}
	
	@ModelAttribute("comfort")
	public Comfort getForm(){
		return new Comfort();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("comforts", service.findAll());
		return "comfort";
	}
	
	@PostMapping
	public String add(@ModelAttribute("comfort") @Valid Comfort comfort, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "comfort";
		}
		service.save(comfort);
		status.setComplete();
		return "redirect:/admin/comfort";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("comfort", service.findOne(id));
		show(model);
		return "comfort";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/comfort";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/comfort";
	}
}
