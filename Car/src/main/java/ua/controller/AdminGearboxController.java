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

import ua.entity.Gearbox;
import ua.service.GearboxService;

@Controller
@RequestMapping("/admin/gearbox")
@SessionAttributes("gearbox")
public class AdminGearboxController {
	
	private final GearboxService service;

	@Autowired
	public AdminGearboxController(GearboxService service) {
		this.service = service;
	}
	
	@ModelAttribute("gearbox")
	public Gearbox getForm(){
		return new Gearbox();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("gearboxes", service.findAll());
		return "gearbox";
	}
	
	@PostMapping
	public String add(@ModelAttribute("gearbox") @Valid Gearbox gearbox, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "gearbox";
		}
		service.save(gearbox);
		status.setComplete();
		return "redirect:/admin/gearbox";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("gearbox", service.findOne(id));
		show(model);
		return "gearbox";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/gearbox";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/gearbox";
	}
}
