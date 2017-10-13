package ua.entity;

public enum Fuel {
	PETROL("Бензин"),
	DIESEL("Дизельне пальне"), 
	GAS("Газ"), 
	PETROL_OR_GAS("Бензин або Газ"), 
	ELECTRO("електромобіль"), 
	HYBRID("Гібрид");
	
	private String value;

	private Fuel(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
