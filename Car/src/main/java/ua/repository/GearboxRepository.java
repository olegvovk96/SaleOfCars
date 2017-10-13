package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Gearbox;

public interface GearboxRepository extends JpaRepository<Gearbox, Integer>{

	Gearbox findByName(String name);
}
