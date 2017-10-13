package ua.domain.request;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Car;

public class PhotoRequest {
	
	private Integer id;
	
	private MultipartFile file;
	
	private Car car;
	
	public PhotoRequest(){}


	public PhotoRequest(Integer id, Car car) {
		this.id = id;
		this.car = car;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}
	
}
