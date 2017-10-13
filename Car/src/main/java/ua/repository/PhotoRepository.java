package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Integer>{
	
	@Query("SELECT ph FROM Photo ph JOIN FETCH ph.car")
	List<Photo> findAllPhoto();
}
