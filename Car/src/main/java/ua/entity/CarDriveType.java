package ua.entity;

public enum CarDriveType {
	FULL_DRIVE("Повний привід"),
	REAR_DRIVE("Задній привід"),
	FRONT_DRIVE("Передній привід");
	
	private String value;
	
	private CarDriveType(final String value) {
		this.value = value;
	}
	
	public String getValue() {
        return value;
    }	
}
