package ua.domain.view;

import java.math.BigDecimal;

public class CarIndex {
	
	private Integer id;
	
	private String photourl;
	
	private Integer version;
		
	private int price;
	
	private int year;
	
	private BigDecimal volume;
	
	private int mileage;
	
	private String mark;
		
	private String model;
	
	private String currency;
	
	private String city;
	
	private String carDriveType;
	
	private String fuel;
	
	private String gearbox;
	
	private String body;
			
	
	public CarIndex(Integer id, String photourl, Integer version, int price, int year,
			String model, String currency, String carDriveType, String mark, BigDecimal volume, 
			String city, int mileage, String fuel, String gearbox, String body) {
		this.id = id;
		this.photourl = photourl;
		this.version = version;
		this.price = price;
		this.year = year;
		this.model = model;
		this.currency = currency;
		this.carDriveType = carDriveType;
		this.mark = mark;
		this.volume = volume;
		this.city = city;
		this.mileage = mileage;
		this.fuel = fuel;
		this.gearbox = gearbox;
		this.body = body;
	}
	
	

	public CarIndex(Integer id, String photourl, Integer version, int price, int year, BigDecimal volume, int mileage,
			String mark, String model, String currency, String city, String gearbox, String body) {
		this.id = id;
		this.photourl = photourl;
		this.version = version;
		this.price = price;
		this.year = year;
		this.volume = volume;
		this.mileage = mileage;
		this.mark = mark;
		this.model = model;
		this.currency = currency;
		this.city = city;
		this.gearbox = gearbox;
		this.body = body;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getCarDriveType() {
		return carDriveType;
	}

	public void setCarDriveType(String carDriveType) {
		this.carDriveType = carDriveType;
	}

	public String getPhotourl() {
		return photourl;
	}

	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
