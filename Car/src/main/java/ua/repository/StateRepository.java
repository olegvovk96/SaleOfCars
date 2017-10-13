package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.State;

public interface StateRepository extends JpaRepository<State, Integer>{
	
	State findByName(String name);
}
