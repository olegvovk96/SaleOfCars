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

import ua.validator.annotation.UniqueMark;

@Entity
@Table(name = "mark")
public class Mark {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer id;
	
	@NotBlank(message="Заповніть поле")
	@UniqueMark(message = "Така марка вже додана")
	private String name;
	
	@OneToMany(mappedBy = "mark")
	private List<Models> models = new ArrayList<>();
	

	public Mark() {}
	
	public Mark(String name) {
		this.name = name;
	}

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

	public List<Models> getModels() {
		return models;
	}

	public void setModels(List<Models> models) {
		this.models = models;
	}
	
}
