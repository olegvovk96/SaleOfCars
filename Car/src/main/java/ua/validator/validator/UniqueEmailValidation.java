package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.UserRepository;
import ua.validator.annotation.UniqueEmail;

public class UniqueEmailValidation implements ConstraintValidator<UniqueEmail, String>{

	@Autowired
	private UserRepository repository;
	
	@Override
	public void initialize(UniqueEmail arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByEmail(arg0) == null;
	}

}
