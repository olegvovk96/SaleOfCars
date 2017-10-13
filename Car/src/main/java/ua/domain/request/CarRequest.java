package ua.domain.request;


import org.springframework.web.multipart.MultipartFile;

import ua.entity.Body;
import ua.entity.CarDriveType;
import ua.entity.City;
import ua.entity.Color;
import ua.entity.Comfort;
import ua.entity.Currency;
import ua.entity.Fuel;
import ua.entity.Gearbox;
import ua.entity.Mark;
import ua.entity.Models;
import ua.entity.Region;
import ua.entity.State;
import ua.entity.UserEntity;

public class CarRequest {

	private Integer id;
	
	private MultipartFile file;
			
	private Models model;
		
	private Color color;
	
	private City city;
		
	private Currency currency;
	
	private State state;
	
	private Gearbox gearbox;
	
	private Comfort comfort;
	
	private Body body;
	
	private CarDriveType carDriveType;
	
	private Fuel fuel;
	
	private Mark mark;
	
	private Region region;
	
	private UserEntity owner;
	
	private String volume;
	
	private String power;
	
	private String numberOfDoors;
	
	private String numberOfSeats;
	
	private String price;
	
	private String year;
	
	private String mileage;
	
	private String description;
		
	public CarRequest(){}

	public CarRequest(Models model, Color color, City city, Currency currency, State state, Gearbox gearbox,
			Comfort comfort, Body body, CarDriveType carDriveType, Fuel fuel, UserEntity owner, String volume,
			String power, String numberOfDoors, String numberOfSeats, String price, String year) {
		this.model = model;
		this.color = color;
		this.city = city;
		this.currency = currency;
		this.state = state;
		this.gearbox = gearbox;
		this.comfort = comfort;
		this.body = body;
		this.carDriveType = carDriveType;
		this.fuel = fuel;
		this.owner = owner;
		this.volume = volume;
		this.power = power;
		this.numberOfDoors = numberOfDoors;
		this.numberOfSeats = numberOfSeats;
		this.price = price;
		this.year = year;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Mark getMark() {
		return mark;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Models getModel() {
		return model;
	}

	public void setModel(Models model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Gearbox getGearbox() {
		return gearbox;
	}

	public void setGearbox(Gearbox gearbox) {
		this.gearbox = gearbox;
	}

	public Comfort getComfort() {
		return comfort;
	}

	public void setComfort(Comfort comfort) {
		this.comfort = comfort;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public CarDriveType getCarDriveType() {
		return carDriveType;
	}

	public void setCarDriveType(CarDriveType carDriveType) {
		this.carDriveType = carDriveType;
	}

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(String numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public String getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
