package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Models;
import ua.repository.ModelRepository;
import ua.service.ModelService;

@Service
public class ModelServiceImplementation implements ModelService{

	private final ModelRepository repository;
	
	@Autowired
	public ModelServiceImplementation(ModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public Models findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Models> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Models entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
