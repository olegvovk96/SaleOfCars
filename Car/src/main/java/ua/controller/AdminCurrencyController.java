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

import ua.entity.Currency;
import ua.service.CurrencyService;

@Controller
@RequestMapping("/admin/currency")
@SessionAttributes("currency")
public class AdminCurrencyController {
	
	private final CurrencyService service;

	@Autowired
	public AdminCurrencyController(CurrencyService service) {
		this.service = service;
	}
	
	@ModelAttribute("currency")
	public Currency getForm(){
		return new Currency();
	}
	
	@GetMapping
	public String show(Model model){
		model.addAttribute("currencies", service.findAll());
		return "currency";
	}
	
	@PostMapping
	public String add(@ModelAttribute("currency") @Valid Currency currency, BindingResult br, Model model, SessionStatus status){
		if(br.hasErrors()){
			show(model);
			return "currency";
		}
		service.save(currency);
		status.setComplete();
		return "redirect:/admin/currency";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable Integer id, Model model){
		model.addAttribute("currency", service.findOne(id));
		show(model);
		return "currency";
	}
	
	@GetMapping("/cancel/{id}")
	public String cancel(SessionStatus status){
		status.setComplete();
		return "redirect:/admin/currency";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id){
		service.delete(id);
		return "redirect:/admin/currency";
	}
}
