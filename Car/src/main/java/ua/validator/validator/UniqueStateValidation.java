package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.StateRepository;
import ua.validator.annotation.UniqueState;

public class UniqueStateValidation implements ConstraintValidator<UniqueState, String>{

	@Autowired
	private StateRepository repository;
	
	@Override
	public void initialize(UniqueState arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
