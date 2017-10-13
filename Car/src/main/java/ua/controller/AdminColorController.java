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

import ua.entity.Color;
import ua.service.ColorService;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes("color")
public class AdminColorController {
	
	private final ColorService service;

	@Autowired
	public AdminColorController(ColorService service) {
		this.service = service;
	}
	
	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("colors", service.findAll());
		return "color";
	}
	
	@PostMapping
	public String add(@ModelAttribute("color") @Valid Color color, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "color";
		}
		service.save(color);
		status.setComplete();
		return "redirect:/admin/color";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("color", service.findOne(id));
		show(model);
		return "color";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/color";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/color";
	}
	
}
