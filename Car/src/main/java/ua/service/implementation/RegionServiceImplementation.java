package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Region;
import ua.repository.RegionRepository;
import ua.service.RegionService;

@Service
public class RegionServiceImplementation implements RegionService{

	private final RegionRepository repository;
	
	@Autowired
	public RegionServiceImplementation(RegionRepository repository) {
		this.repository = repository;
	}

	@Override
	public Region findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Region> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Region entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
