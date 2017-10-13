package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Currency;
import ua.repository.CurrencyRepository;
import ua.service.CurrencyService;

@Service
public class CurrencyServiceImplementation implements CurrencyService{

	private final CurrencyRepository repository;
	
	@Autowired
	public CurrencyServiceImplementation(CurrencyRepository repository) {
		this.repository = repository;
	}

	@Override
	public Currency findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Currency> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Currency entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
