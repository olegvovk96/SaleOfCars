package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.City;
import ua.service.CityService;

public class CityEditor extends PropertyEditorSupport{
	
	private final CityService service;

	public CityEditor(CityService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		City city = service.findOne(Integer.parseInt(text));
		setValue(city);
	}
	
}
