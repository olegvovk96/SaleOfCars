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

import ua.editor.MarkEditor;
import ua.entity.Mark;
import ua.entity.Models;
import ua.service.MarkService;
import ua.service.ModelService;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes("model")
public class AdminModelController {
	
	private final ModelService service;
	
	private final MarkService markService;

	@Autowired
	public AdminModelController(ModelService service, MarkService markService) {
		this.service = service;
		this.markService = markService;
	}
	
	@ModelAttribute("model")
	public Models getForm(){
		return new Models();
	}
	
	@InitBinder("model")
	protected void initBinder(WebDataBinder webDataBinder){
		webDataBinder.registerCustomEditor(Mark.class, new MarkEditor(markService));
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("models", service.findAll());
		model.addAttribute("marks", markService.findAll());
		return "model";
	}
	
	@PostMapping
	public String add(@ModelAttribute("model") @Valid Models model, BindingResult br, Model modell, SessionStatus status){
		if(br.hasErrors()){
			show(modell);
			return "model";
		}
		service.save(model);
		status.setComplete();
		return "redirect:/admin/model";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("model", service.findOne(id));
		show(model);
		return "model";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/model";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/model";
	}
	
}
