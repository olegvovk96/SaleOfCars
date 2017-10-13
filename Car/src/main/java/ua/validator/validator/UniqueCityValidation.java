package ua.validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import ua.repository.CityRepository;
import ua.validator.annotation.UniqueCity;

public class UniqueCityValidation implements ConstraintValidator<UniqueCity, String>{

	@Autowired
	private CityRepository repository;
	
	@Override
	public void initialize(UniqueCity arg0) {
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		return repository.findByName(arg0) == null;
	}

}
