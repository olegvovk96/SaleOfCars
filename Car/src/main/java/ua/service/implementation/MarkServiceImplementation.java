package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Mark;
import ua.repository.MarkRepository;
import ua.service.MarkService;

@Service
public class MarkServiceImplementation implements MarkService{

	private final MarkRepository repository;
	
	@Autowired
	public MarkServiceImplementation(MarkRepository repository) {
		this.repository = repository;
	}

	@Override
	public Mark findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Mark> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Mark entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
