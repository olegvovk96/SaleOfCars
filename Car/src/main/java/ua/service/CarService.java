package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.domain.request.CarRequest;
import ua.domain.view.CarByUserId;
import ua.domain.view.CarIndex;
import ua.domain.view.CarMain;
import ua.entity.Car;

public interface CarService extends CrudService<Car, Integer>{
	
	List<CarIndex> findAllIndex();
	
	Page<CarIndex> findAllIndex(Pageable pageable);
	
	List<CarMain> findOneMainIndex(Integer id);
	
	List<CarByUserId> findByUserId(String email);
	
	void save(CarRequest request);

}
