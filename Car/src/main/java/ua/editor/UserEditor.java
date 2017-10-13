package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.UserEntity;
import ua.repository.UserRepository;

public class UserEditor extends PropertyEditorSupport{
	
	private final UserRepository repository;

	public UserEditor(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		UserEntity userEntity = repository.findByEmail(text);
		setValue(userEntity);
	}
	
	
}
