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

import ua.entity.State;
import ua.service.StateService;

@Controller
@RequestMapping("/admin/state")
@SessionAttributes("state")
public class AdminStateController {

	private final StateService service;

	@Autowired
	public AdminStateController(StateService service) {
		this.service = service;
	}
	
	@ModelAttribute("state")
	public State getForm(){
		return new State();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("states", service.findAll());
		return "state";
	}
	
	@PostMapping
	public String add(@ModelAttribute("state") @Valid State state, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "state";
		}
		service.save(state);
		status.setComplete();
		return "redirect:/admin/state";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("state", service.findOne(id));
		show(model);
		return "state";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/state";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/state";
	}
}
