package ua.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.editor.RegionEditor;
import ua.entity.City;
import ua.entity.Region;
import ua.service.CityService;
import ua.service.RegionService;

@Controller
@RequestMapping("/admin/city")
@SessionAttributes("city")
public class AdminCityController {

	private final CityService service;
	
	private final RegionService regionService;

	@Autowired
	public AdminCityController(CityService service, RegionService regionService) {
		this.service = service;
		this.regionService = regionService;
	}
	
	@ModelAttribute("city")
	public City getForm(){
		return new City();
	}
	
	@InitBinder("city")
	protected void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Region.class, new RegionEditor(regionService));
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("cities", service.findAll());
		model.addAttribute("regions", regionService.findAll());
		return "city";
	}
	
	@PostMapping
	public String add(@ModelAttribute("city") @Valid City city, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "city";
		}
		service.save(city);
		status.setComplete();
		return "redirect:/admin/city";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("city", service.findOne(id));
		show(model);
		return "city";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/city";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/city";
	}
	
}
