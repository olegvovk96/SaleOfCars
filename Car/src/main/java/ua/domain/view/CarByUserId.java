package ua.domain.view;

public class CarByUserId {
	
	private Integer id;
	
	private String model;
	
	private String owner;

	public CarByUserId(Integer id, String model, String owner) {
		this.id = id;
		this.model = model;
		this.owner = owner;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
