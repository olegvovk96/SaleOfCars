package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Comfort;

public interface ComfortRepository extends JpaRepository<Comfort, Integer>{

	Comfort findByName(String name);
}
