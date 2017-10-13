package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.City;
import ua.repository.CityRepository;
import ua.service.CityService;

@Service
public class CityServiceImplementation implements CityService{

	private final CityRepository repository;
	
	@Autowired
	public CityServiceImplementation(CityRepository repository) {
		this.repository = repository;
	}

	@Override
	public City findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<City> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(City entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
