package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Comfort;
import ua.repository.ComfortRepository;
import ua.service.ComfortService;

@Service
public class ComfortServiceImplementation implements ComfortService{

	private final ComfortRepository repository;
	
	@Autowired
	public ComfortServiceImplementation(ComfortRepository repository) {
		this.repository = repository;
	}

	@Override
	public Comfort findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Comfort> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Comfort entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
