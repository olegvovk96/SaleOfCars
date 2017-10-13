package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	UserEntity findByEmail(String email);
}
