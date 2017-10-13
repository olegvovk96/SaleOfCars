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

import ua.entity.Region;
import ua.service.RegionService;

@Controller
@RequestMapping("/admin/region")
@SessionAttributes("region")
public class AdminRegionController {
	
	private final RegionService service;

	@Autowired
	public AdminRegionController(RegionService service) {
		this.service = service;
	}
	
	@ModelAttribute("region")
	public Region getForm(){
		return new Region();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("regions", service.findAll());
		return "region";
	}
	
	@PostMapping
	public String add(@ModelAttribute("region") @Valid Region region, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "region";
		}
		service.save(region);
		status.setComplete();
		return "redirect:/admin/region";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("region", service.findOne(id));
		show(model);
		return "region";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/region";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/region";
	}
	
}
