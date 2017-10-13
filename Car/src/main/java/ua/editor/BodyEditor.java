package ua.editor;

import java.beans.PropertyEditorSupport;


import ua.entity.Body;
import ua.service.BodyService;

public class BodyEditor extends PropertyEditorSupport{
	
	private final BodyService service;

	public BodyEditor(BodyService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Body body = service.findOne(Integer.parseInt(text));
		setValue(body);
	}
	
	
	
}
