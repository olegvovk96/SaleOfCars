package ua.entity;

import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = LAZY)
	private Models model;
	
	@ManyToOne(fetch = LAZY)
	private Color color;
	
	@ManyToOne(fetch = LAZY)
	private City city;
	
	@ManyToOne(fetch = LAZY)
	private Currency currency;
	
	@ManyToOne(fetch = LAZY)
	private State state;
	
	@ManyToOne(fetch = LAZY)
	private Gearbox gearbox;
	
	@ManyToOne(fetch = LAZY)
	private Comfort comfort;
	
	private CarDriveType carDriveType;
	
	private Fuel fuel;
	
	@ManyToOne(fetch = LAZY)
	private Body body;
	
	@ManyToOne(fetch = LAZY)
	private UserEntity owner;
	
	@OneToMany(mappedBy = "car")
	private List<Photo> photos = new ArrayList<>();
	
	private String photourl;
	
	private Integer version;
	
	private BigDecimal volume;
	
	private int power;
		
	private int price;
	
	private int year;
	
	private int numberOfDoors;
	
	private int numberOfSeats;
	
	private int mileage;
	
	private String description;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
	}

	
	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
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

}
