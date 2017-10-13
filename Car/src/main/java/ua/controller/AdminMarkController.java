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

import ua.entity.Mark;
import ua.service.MarkService;

@Controller
@RequestMapping("/admin/mark")
@SessionAttributes("mark")
public class AdminMarkController {
	
	private final MarkService service;
	
	@Autowired
	public AdminMarkController(MarkService service) {
		this.service = service;
	}
	
	@ModelAttribute("mark")
	public Mark getForm(){
		return new Mark();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("marks", service.findAll());
		return "mark";
	}
	
	@PostMapping
	public String add(@ModelAttribute("mark") @Valid Mark mark, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "mark";
		}
		service.save(mark);
		status.setComplete();
		return "redirect:/admin/mark";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("mark", service.findOne(id));
		show(model);
		return "mark";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/mark";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/mark";
	}
	
}
