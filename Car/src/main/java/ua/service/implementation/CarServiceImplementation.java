package ua.service.implementation;

import static ua.mapper.CarMapper.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.domain.request.CarRequest;
import ua.domain.view.CarByUserId;
import ua.domain.view.CarIndex;
import ua.domain.view.CarMain;
import ua.entity.Car;
import ua.repository.CarRepository;
import ua.service.CarService;

@Service
public class CarServiceImplementation implements CarService{
	
	private final CarRepository repository;

	@Autowired
	public CarServiceImplementation(CarRepository repository) {
		this.repository = repository;
	}
	
	@Value("${file.path}")
	private String path;

	@Override
	public Car findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public List<Car> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Car entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public List<CarIndex> findAllIndex() {
		return toCarIndex(repository.findAllCarIndex());
	}
	
	@Override
	public List<CarMain> findOneMainIndex(Integer id) {
		return toCarMainIndex(repository.findOneCarMainIndex(id));
	}
	
	@Override
	public List<CarByUserId> findByUserId(String email) {
		return repository.findUserByIndex(email);
	}
	
	@Override
	public Page<CarIndex> findAllIndex(Pageable pageable) {
		return repository.findCarIndex(pageable);
	}
	
	@Override
	public void save(CarRequest request) {
		Car car = toCar(request);
		MultipartFile file = request.getFile();
		if(file != null && !file.isEmpty()){
			String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			String fileName = UUID.randomUUID().toString()+extention;
			try {
				file.transferTo(new File(path + fileName));
				car.setPhotourl(fileName);
				car.setVersion(1);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} 
		}		
			System.out.println(car.getPhotourl());
			repository.save(car);
	}

}
