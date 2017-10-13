package ua.domain.view;

import java.math.BigDecimal;
import java.util.List;


public class CarMain {
	
	private Integer id;
	
	private String photourl;
	
	private Integer version;
	
	private String mark;
	
	private String model;
	
	private String region;
	
	private String city;
	
	private String color;
	
	private String comfort;
	
	private String currency;
	
	private String gearbox;
	
	private String state;
	
	private String body;
	
	private String owner;
	
	private String carDriveType;
	
	private String fuel;
	
	private BigDecimal volume;
	
	private int power;
	
	private int numberOfDoors;
	
	private int numberOfSeats;
	
	private int price;
	
	private int year;
	
	private int mileage;
	
	private String description;
	
	private List<String> photos;
	
	public Integer getId() {
		return id;
	}

	public CarMain(Integer id, String photourl, Integer version, String mark, String model, String region, String city,
			String color, String comfort, String currency, String gearbox, String state, String body, String owner,
			String carDriveType, String fuel, BigDecimal volume, int power, int numberOfDoors, int numberOfSeats,
			int price, int year, int mileage, String description, List<String> photos) {
		this.id = id;
		this.photourl = photourl;
		this.version = version;
		this.mark = mark;
		this.model = model;
		this.region = region;
		this.city = city;
		this.color = color;
		this.comfort = comfort;
		this.currency = currency;
		this.gearbox = gearbox;
		this.state = state;
		this.body = body;
		this.owner = owner;
		this.carDriveType = carDriveType;
		this.fuel = fuel;
		this.volume = volume;
		this.power = power;
		this.numberOfDoors = numberOfDoors;
		this.numberOfSeats = numberOfSeats;
		this.price = price;
		this.year = year;
		this.mileage = mileage;
		this.description = description;
		this.photos = photos;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getComfort() {
		return comfort;
	}

	public void setComfort(String comfort) {
		this.comfort = comfort;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getCarDriveType() {
		return carDriveType;
	}

	public void setCarDriveType(String carDriveType) {
		this.carDriveType = carDriveType;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}
	
}
