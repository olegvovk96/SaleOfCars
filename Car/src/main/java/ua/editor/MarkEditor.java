package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.Mark;
import ua.service.MarkService;

public class MarkEditor extends PropertyEditorSupport{
	
	private final MarkService service;

	public MarkEditor(MarkService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Mark mark = service.findOne(Integer.parseInt(text));
		setValue(mark);
	}
}
