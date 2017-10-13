package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer>{
	
	Mark findByName(String name); 
}
