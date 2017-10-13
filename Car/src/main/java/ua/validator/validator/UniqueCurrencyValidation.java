package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.CurrencyRepository;
import ua.validator.annotation.UniqueCurrency;

public class UniqueCurrencyValidation implements ConstraintValidator<UniqueCurrency, String>{

	@Autowired
	private CurrencyRepository repository;
	
	@Override
	public void initialize(UniqueCurrency arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
