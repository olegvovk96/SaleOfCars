package ua.editor;

import java.beans.PropertyEditorSupport;


import ua.entity.State;
import ua.service.StateService;

public class StateEditor extends PropertyEditorSupport{

	private final StateService service;

	public StateEditor(StateService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		State state = service.findOne(Integer.parseInt(text));
		setValue(state);
	}
}
