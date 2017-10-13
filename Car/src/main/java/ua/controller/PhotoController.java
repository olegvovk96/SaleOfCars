package ua.controller;


import java.io.File;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.domain.request.PhotoRequest;
import ua.entity.Photo;
import ua.service.CarService;
import ua.service.PhotoService;

@Controller
@RequestMapping("/addPhoto")
@SessionAttributes("photo")
public class PhotoController {
	
	private final PhotoService service;
	
	private final CarService carService;
	
	@Value("${file.path}")
	private String path;

	
	@Autowired
	public PhotoController(PhotoService service, CarService carService) {
		this.service = service;
		this.carService = carService;
	}

	@ModelAttribute("photo")
	public PhotoRequest getForm(){
		return new PhotoRequest();
	}
	
	@GetMapping
	public String show(Model model, Principal principal){
		model.addAttribute("photos", service.findAll());
		model.addAttribute("cars", carService.findByUserId(principal.getName()));
		return "addPhoto";
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ROLE_OWNER')")
	public String add(@ModelAttribute("photo") PhotoRequest photoRequest, Principal principal, SessionStatus status){
		service.save(photoRequest);
		status.setComplete();
		return "redirect:/addPhoto";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		Photo photo = service.findOne(id);
		File file = new File(path + photo.getPhotourl());
		if(file != null){
			file.delete();
		}
		service.delete(id);
		return "redirect:/addPhoto";
	}
}
