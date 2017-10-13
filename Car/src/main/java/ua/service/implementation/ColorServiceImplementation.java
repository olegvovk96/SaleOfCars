package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Color;
import ua.repository.ColorRepository;
import ua.service.ColorService;

@Service
public class ColorServiceImplementation implements ColorService{

	private final ColorRepository repository;
	
	@Autowired
	public ColorServiceImplementation(ColorRepository repository) {
		this.repository = repository;
	}

	@Override
	public Color findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Color> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Color entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
