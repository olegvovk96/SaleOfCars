package ua.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


import ua.domain.request.CarRequest;
import ua.domain.view.CarIndex;
import ua.domain.view.CarMain;
import ua.entity.Car;
import ua.entity.Photo;

public interface CarMapper {
	
	public static CarIndex toCarIndex(Car car){
		Integer id = car.getId();
		String photourl = car.getPhotourl();
		Integer version = car.getVersion();
		int price = car.getPrice();
		int year = car.getYear();
		BigDecimal volume = car.getVolume();
		int mileage = car.getMileage();
		String model = car.getModel().getName();
		String currency = car.getCurrency().getName();
		String carDriveType = car.getCarDriveType().getValue();
		String mark = car.getModel().getMark().getName();
		String city = car.getCity().getName();
		String fuel = car.getFuel().getValue();
		String gearbox = car.getGearbox().getName();
		String body = car.getBody().getName();
		return new CarIndex(id, photourl, version, price, year, model, currency, carDriveType,
				   mark, volume, city, mileage, fuel, gearbox, body);
	}
	
	public static CarMain toCarMainIndex(Car car){
		Integer id = car.getId();
		String photourl = car.getPhotourl();
		Integer version = car.getVersion();
		String mark = car.getModel().getMark().getName();
		String model = car.getModel().getName();
		String region = car.getCity().getRegion().getName();
		String city = car.getCity().getName();
		String color = car.getColor().getName();
		String comfort = car.getComfort().getName();
		String currency = car.getCurrency().getName();
		String gearbox = car.getGearbox().getName();
		String state = car.getState().getName();
		String body = car.getBody().getName();
		String owner = car.getOwner().getNumberMobilePhone().concat(" - " + car.getOwner().getName());
		String carDriveType = car.getCarDriveType().getValue();
		String fuel = car.getFuel().getValue();
		BigDecimal volume = car.getVolume();
		int power = car.getPower();
		int numberOfDoors = car.getNumberOfDoors();
		int numberOfSeats = car.getNumberOfSeats();
		int price = car.getPrice();
		int year = car.getYear();
		int mileage = car.getMileage();
		String description = car.getDescription();
		List<String> photos = new ArrayList<>();
		Iterator<Photo> iterator = car.getPhotos().iterator();
		while (iterator.hasNext()) {
			Photo photo = iterator.next();
			photos.add(photo.getPhotourl());
		}
		return new CarMain(id, photourl, version, mark, model, region, city, color, comfort,
				           currency, gearbox, state, body, owner, carDriveType, fuel, volume, 
				           power, numberOfDoors, numberOfSeats, price, year, mileage, description, photos);
	}
	
	
	public static List<CarIndex> toCarIndex(List<Car> cars){
		return cars.stream()
			   .map(CarMapper::toCarIndex)
			   .collect(Collectors.toList());
	}
	
	public static List<CarMain> toCarMainIndex(List<Car> cars){
		return cars.stream()
				.map(CarMapper::toCarMainIndex)
				.collect(Collectors.toList());
	}
	
	public static Car toCar(CarRequest request){
		Car car = new Car();
		car.setModel(request.getModel());
		car.getModel().setMark(request.getMark());
		car.setColor(request.getColor());
		car.setCity(request.getCity());
		car.getCity().setRegion(request.getRegion());
		car.setCurrency(request.getCurrency());
		car.setState(request.getState());
		car.setGearbox(request.getGearbox());
		car.setComfort(request.getComfort());
		car.setBody(request.getBody());
		car.setCarDriveType(request.getCarDriveType());
		car.setFuel(request.getFuel());
		car.setOwner(request.getOwner());
		car.setId(request.getId());
		car.setVolume(new BigDecimal(request.getVolume()));
		car.setPower(Integer.valueOf(request.getPower()));
		car.setPrice(Integer.valueOf(request.getPrice()));
		car.setNumberOfDoors(Integer.valueOf(request.getNumberOfDoors()));
		car.setNumberOfSeats(Integer.valueOf(request.getNumberOfSeats()));
		car.setYear(Integer.valueOf(request.getYear()));
		car.setMileage(Integer.valueOf(request.getMileage()));
		car.setDescription(request.getDescription());
		
		return car;
	}
}
