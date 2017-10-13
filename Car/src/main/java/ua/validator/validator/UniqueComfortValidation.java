package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.ComfortRepository;
import ua.validator.annotation.UniqueComfort;

public class UniqueComfortValidation implements ConstraintValidator<UniqueComfort, String>{

	@Autowired
	private ComfortRepository repository;
	
	@Override
	public void initialize(UniqueComfort arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
