package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.RegionRepository;
import ua.validator.annotation.UniqueRegion;

public class UniqueRegionValidation implements ConstraintValidator<UniqueRegion, String>{

	@Autowired
	private RegionRepository repository;
	
	@Override
	public void initialize(UniqueRegion arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
