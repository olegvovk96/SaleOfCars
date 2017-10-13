package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Body;

public interface BodyRepository extends JpaRepository<Body, Integer> {
	
	Body findByName(String name);
}
