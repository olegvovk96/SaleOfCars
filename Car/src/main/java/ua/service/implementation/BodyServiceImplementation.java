package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Body;
import ua.repository.BodyRepository;
import ua.service.BodyService;

@Service
public class BodyServiceImplementation implements BodyService{

	private final BodyRepository repository;
	
	@Autowired
	public BodyServiceImplementation(BodyRepository repository) {
		this.repository = repository;
	}

	@Override
	public Body findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Body> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Body entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
	
	

}
