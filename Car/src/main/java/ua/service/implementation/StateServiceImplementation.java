package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.State;
import ua.repository.StateRepository;
import ua.service.StateService;

@Service
public class StateServiceImplementation implements StateService{

	private final StateRepository repository;
	
	@Autowired
	public StateServiceImplementation(StateRepository repository) {
		this.repository = repository;
	}

	@Override
	public State findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<State> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(State entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
