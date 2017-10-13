package ua.mapper;

import ua.domain.request.RegistrationRequest;
import ua.entity.Role;
import ua.entity.UserEntity;

public interface RegistrationMapper {
	public static UserEntity map(RegistrationRequest registrationRequest){
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(registrationRequest.getEmail());
		userEntity.setPassword(registrationRequest.getPassword());
		userEntity.setName(registrationRequest.getName());
		userEntity.setNumberMobilePhone(registrationRequest.getNumberMobilePhone());
		if(registrationRequest.getIsOwner()){
			userEntity.setRole(Role.ROLE_OWNER);
		} else{
			userEntity.setRole(Role.ROLE_USER);
		}
		
		return userEntity;
	}
}
