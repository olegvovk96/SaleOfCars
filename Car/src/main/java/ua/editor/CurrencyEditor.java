package ua.editor;

import java.beans.PropertyEditorSupport;


import ua.entity.Currency;
import ua.service.CurrencyService;

public class CurrencyEditor extends PropertyEditorSupport{
	
	private final CurrencyService service;

	public CurrencyEditor(CurrencyService service) {
		this.service = service;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Currency currency = service.findOne(Integer.parseInt(text));
		setValue(currency);
	}
	
	
}
