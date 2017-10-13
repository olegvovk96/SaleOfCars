package ua.editor;

import java.beans.PropertyEditorSupport;


import ua.entity.Gearbox;
import ua.service.GearboxService;

public class GearboxEditor extends PropertyEditorSupport{
	
	private final GearboxService service;

	public GearboxEditor(GearboxService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Gearbox gearbox = service.findOne(Integer.parseInt(text));
		setValue(gearbox);
	}	
}
