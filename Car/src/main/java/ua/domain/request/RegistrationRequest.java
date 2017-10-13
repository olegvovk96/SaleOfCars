package ua.domain.request;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import ua.validator.annotation.UniqueEmail;

public class RegistrationRequest {
	
	@NotBlank(message = "Це поле потрібно заповнити")
	@Email(message = "Неправильний формат Email")
	@UniqueEmail(message = "Такий Email вже зайнятий")
	private String email;
	
	@NotBlank(message = "Це поле потрібно заповнити")
	@Size(min = 6,
	      message="Пароль має бути не менше 6 символів")
	private String password;
	
	@NotBlank(message = "Це поле потрібно заповнити")
	private String passwordRepeat;
	
	@NotBlank(message = "Це поле потрібно заповнити")
	@Size(min = 3, 
		  max = 15,
		  message="Кількість символів повинна бути від 3 до 15")
	private String name;
	
	@NotBlank(message = "Це поле потрібно заповнити")
	@Pattern(regexp = "\\d{3} \\d{3}-\\d{2}-\\d{2}",
	         message = "Введений номер не відповідає шаблону")
	private String numberMobilePhone;
	
	private boolean isOwner;
	
	private boolean checkPass;
	
	@AssertTrue(message = "Ці паролі не збігаються. Повторити спробу?")
	public boolean isCheckPass(){
		if(password == null){
			return false;
		}
		return password.equals(passwordRepeat);
	}
	
	
	public void setCheckPass(boolean checkPass) {
		this.checkPass = checkPass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	public String getNumberMobilePhone() {
		return numberMobilePhone;
	}

	public void setNumberMobilePhone(String numberMobilePhone) {
		this.numberMobilePhone = numberMobilePhone;
	}

	public boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(boolean isOwner) {
		this.isOwner = isOwner;
	}


	@Override
	public String toString() {
		return "RegistrationRequest [email=" + email + ", password=" + password + ", passwordRepeat=" + passwordRepeat
				+ ", name=" + name + ", numberMobilePhone=" + numberMobilePhone + ", isOwner=" + isOwner
				+ ", checkPass=" + checkPass + "]";
	}

	

}
