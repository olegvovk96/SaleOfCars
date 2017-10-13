package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Region;
import ua.service.RegionService;

public class RegionEditor extends PropertyEditorSupport{

	private final RegionService service;

	public RegionEditor(RegionService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Region region = service.findOne(Integer.parseInt(text));
		setValue(region);
	}
}
