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

import ua.validator.annotation.UniqueRegion;

@Entity
@Table(name = "region")
public class Region {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@NotBlank(message="Заповніть поле")
	@UniqueRegion(message="Така область вже додана")
	private String name;
	
	@OneToMany(mappedBy = "region")
	private List<City> cities = new ArrayList<>();
	
	
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

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
