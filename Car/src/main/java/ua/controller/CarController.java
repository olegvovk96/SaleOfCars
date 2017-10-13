package ua.controller;



import java.security.Principal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.yaml.snakeyaml.error.Mark;

import ua.domain.request.CarRequest;
import ua.editor.BodyEditor;
import ua.editor.CityEditor;
import ua.editor.ColorEditor;
import ua.editor.ComfortEditor;
import ua.editor.CurrencyEditor;
import ua.editor.GearboxEditor;
import ua.editor.MarkEditor;
import ua.editor.ModelEditor;
import ua.editor.RegionEditor;
import ua.editor.StateEditor;
import ua.editor.UserEditor;
import ua.entity.Body;
import ua.entity.CarDriveType;
import ua.entity.City;
import ua.entity.Color;
import ua.entity.Comfort;
import ua.entity.Currency;
import ua.entity.Fuel;
import ua.entity.Gearbox;
import ua.entity.Models;
import ua.entity.Region;
import ua.entity.State;
import ua.entity.UserEntity;
import ua.repository.UserRepository;
import ua.service.BodyService;
import ua.service.CarService;
import ua.service.CityService;
import ua.service.ColorService;
import ua.service.ComfortService;
import ua.service.CurrencyService;
import ua.service.GearboxService;
import ua.service.MarkService;
import ua.service.ModelService;
import ua.service.PhotoService;
import ua.service.RegionService;
import ua.service.StateService;

@Controller
@SessionAttributes("car")
public class CarController {
	
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
	
	private final PhotoService photoService;
		
	@Autowired
	private UserRepository userRepository;
	
	@ModelAttribute("car")
	public CarRequest getForm(){
		return new CarRequest();
	}
	
	@InitBinder("car")
	protected void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Models.class, new ModelEditor(modelService));
		webDataBinder.registerCustomEditor(Body.class, new BodyEditor(bodyService));
		webDataBinder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		webDataBinder.registerCustomEditor(Comfort.class, new ComfortEditor(comfortService));
		webDataBinder.registerCustomEditor(Currency.class, new CurrencyEditor(currencyService));
		webDataBinder.registerCustomEditor(Gearbox.class, new GearboxEditor(gearboxService));
		webDataBinder.registerCustomEditor(State.class, new StateEditor(stateService));
		webDataBinder.registerCustomEditor(City.class, new CityEditor(cityService));
		webDataBinder.registerCustomEditor(UserEntity.class, new UserEditor(userRepository));
		webDataBinder.registerCustomEditor(Mark.class, new MarkEditor(markService));
		webDataBinder.registerCustomEditor(Region.class, new RegionEditor(regionService));
	}
	
	@Autowired
	public CarController(CarService service, BodyService bodyService, ColorService colorService,
			ComfortService comfortService, CurrencyService currencyService, GearboxService gearboxService,
			CityService cityService, ModelService modelService, StateService stateService, MarkService markService,
			RegionService regionService, UserRepository userRepository, PhotoService photoService) {
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
		this.userRepository = userRepository;
		this.photoService = photoService;
	}

	@GetMapping("/car")
	public String show(Model model){
		model.addAttribute("cars", service.findAllIndex());
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
		return "car";
	}
	
	@GetMapping("/car/{id}")
	public String showIndexCar(Model model, @PathVariable Integer id){
		model.addAttribute("cars", service.findOneMainIndex(id));
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
		model.addAttribute("photos", photoService.findAll());
		model.addAttribute("carDriveTypes", Arrays.asList(CarDriveType.values()));
		model.addAttribute("fuels", Arrays.asList(Fuel.values()));
		return "carIndex";
	}
	
	@PostMapping("/car")
	@PreAuthorize("hasRole('ROLE_OWNER')")
	public String add(@ModelAttribute("car") CarRequest carRequest, Principal principal, SessionStatus status){
		System.out.println(principal.getName());
        service.save(carRequest);
        status.setComplete();
		return "redirect:/car";
	}
}
