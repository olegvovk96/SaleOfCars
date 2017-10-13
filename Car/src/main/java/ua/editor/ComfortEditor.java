package ua.editor;

import java.beans.PropertyEditorSupport;


import ua.entity.Comfort;
import ua.service.ComfortService;

public class ComfortEditor extends PropertyEditorSupport{
	
	private final ComfortService service;

	public ComfortEditor(ComfortService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Comfort comfort = service.findOne(Integer.parseInt(text));
		setValue(comfort);
	}
	
	
}
