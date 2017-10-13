package ua.domain.view;

public class PhotoDto {

	private Integer id;
	
	private String photourl;
	
	private Integer version;
	
	private String car;

	
	public PhotoDto(Integer id, String photourl, Integer version, String car) {
		this.id = id;
		this.photourl = photourl;
		this.version = version;
		this.car = car;
	}
	

	public Integer getId() {
		return id;
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

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
}
