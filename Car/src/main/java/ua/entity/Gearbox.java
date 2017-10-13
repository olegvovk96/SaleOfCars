package ua.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import ua.validator.annotation.UniqueGearbox;

@Entity
@Table(name = "gearbox")
public class Gearbox {
		
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@NotBlank(message="Заповніть поле")
	@UniqueGearbox(message="Така коробка передач вже додана")
	private String name;
	
	@OneToMany(mappedBy = "gearbox")
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

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
}
