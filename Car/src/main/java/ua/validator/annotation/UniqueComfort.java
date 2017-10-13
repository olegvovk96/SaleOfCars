package ua.validator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import ua.validator.validator.UniqueComfortValidation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueComfortValidation.class)
public @interface UniqueComfort {

	String message() default "Not Unique";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default {};
}
