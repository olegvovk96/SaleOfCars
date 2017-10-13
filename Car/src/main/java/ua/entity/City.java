package ua.entity;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import ua.validator.annotation.UniqueCity;

@Entity
@Table(name = "city")
public class City {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@NotBlank(message="Заповніть поле")
	@UniqueCity(message="Таке місто вже додане")
	private String name;
	
	@ManyToOne(fetch = LAZY)
	private Region region;
	
	@OneToMany(mappedBy = "city")
	private List<Car> cars = new ArrayList<>();
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
}
