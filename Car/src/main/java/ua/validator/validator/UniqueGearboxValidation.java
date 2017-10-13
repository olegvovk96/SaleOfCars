package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.GearboxRepository;
import ua.validator.annotation.UniqueGearbox;

public class UniqueGearboxValidation implements ConstraintValidator<UniqueGearbox, String>{

	@Autowired
	private GearboxRepository repository;
	
	@Override
	public void initialize(UniqueGearbox arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
