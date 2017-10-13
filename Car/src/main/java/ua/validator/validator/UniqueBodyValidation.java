package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.BodyRepository;
import ua.validator.annotation.UniqueBody;

public class UniqueBodyValidation implements ConstraintValidator<UniqueBody, String>{

	@Autowired
	private BodyRepository repository;
	
	@Override
	public void initialize(UniqueBody arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
