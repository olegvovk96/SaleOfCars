package ua.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ua.entity.CarDriveType;
import ua.entity.Fuel;
import ua.service.BodyService;
import ua.service.CarService;
import ua.service.CityService;
import ua.service.ColorService;
import ua.service.ComfortService;
import ua.service.CurrencyService;
import ua.service.GearboxService;
import ua.service.MarkService;
import ua.service.ModelService;
import ua.service.RegionService;
import ua.service.StateService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	private final CarService service;
	
	private final BodyService bodyService;
	
	private final ColorService colorService;
	
	private final ComfortService comfortService;
	
	private final CurrencyService currencyService;
		
	private final GearboxService gearboxService;
	
	private final CityService cityService;
		
	private final ModelService modelService;
		
	private final StateService stateService;
	
	private final MarkService markService;
	
	private final RegionService regionService;
	
	
	@Autowired
	public IndexController(CarService service, BodyService bodyService, ColorService colorService,
			ComfortService comfortService, CurrencyService currencyService, GearboxService gearboxService,
			CityService cityService, ModelService modelService, StateService stateService, MarkService markService,
			RegionService regionService) {
		this.service = service;
		this.bodyService = bodyService;
		this.colorService = colorService;
		this.comfortService = comfortService;
		this.currencyService = currencyService;
		this.gearboxService = gearboxService;
		this.cityService = cityService;
		this.modelService = modelService;
		this.stateService = stateService;
		this.markService = markService;
		this.regionService = regionService;
	}
	
	@GetMapping("/")
	public String welcome(Model model, @PageableDefault(5) Pageable pageable){
		model.addAttribute("cars", service.findAllIndex(pageable));
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("bodies", bodyService.findAll());
		model.addAttribute("colors", colorService.findAll());
		model.addAttribute("comforts", comfortService.findAll());
		model.addAttribute("currencies", currencyService.findAll());
		model.addAttribute("gearboxes", gearboxService.findAll());
		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("states", stateService.findAll());
		model.addAttribute("marks", markService.findAll());
		model.addAttribute("regions", regionService.findAll());
		model.addAttribute("carDriveTypes", Arrays.asList(CarDriveType.values()));
		model.addAttribute("fuels", Arrays.asList(Fuel.values()));
		return "index";
	}
	
	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}
}
