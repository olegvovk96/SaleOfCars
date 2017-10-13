package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.repository.MarkRepository;
import ua.validator.annotation.UniqueMark;

@Component
public class UniqueMarkValidation implements ConstraintValidator<UniqueMark, String>{

	@Autowired
	private MarkRepository repository;
	
	@Override
	public void initialize(UniqueMark arg0) {		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
