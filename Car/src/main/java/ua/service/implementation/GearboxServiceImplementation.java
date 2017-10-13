package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Gearbox;
import ua.repository.GearboxRepository;
import ua.service.GearboxService;

@Service
public class GearboxServiceImplementation implements GearboxService{

	private final GearboxRepository repository;
	
	@Autowired
	public GearboxServiceImplementation(GearboxRepository repository) {
		this.repository = repository;
	}

	@Override
	public Gearbox findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Gearbox> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Gearbox entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
