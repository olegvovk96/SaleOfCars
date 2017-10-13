package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.domain.view.CarByUserId;
import ua.domain.view.CarIndex;
import ua.entity.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{
	
	@Query("SELECT c FROM Car c JOIN FETCH c.model JOIN FETCH c.body JOIN FETCH c.color JOIN FETCH c.comfort JOIN FETCH c.currency JOIN FETCH c.gearbox JOIN FETCH c.state JOIN FETCH c.city JOIN FETCH c.owner WHERE c.id = ?1")
	List<Car> findOneCarMainIndex(Integer id);
	
	@Query("SELECT c FROM Car c JOIN FETCH c.city JOIN FETCH c.model JOIN FETCH c.currency JOIN FETCH c.gearbox JOIN FETCH c.body")
	List<Car> findAllCarIndex();
	
	@Query("SELECT new ua.domain.view.CarByUserId(c.id, m.name, ow.email) FROM Car c JOIN c.model m JOIN c.owner ow WHERE ow.email = ?1")
	List<CarByUserId> findUserByIndex(String email);
	
	@Query("SELECT new ua.domain.view.CarIndex(c.id, c.photourl, c.version, c.price, c.year, c.volume, c.mileage, mar.name, m.name, cur.name, cit.name, g.name, b.name) FROM Car c JOIN c.model.mark mar JOIN c.model m JOIN c.currency cur  JOIN c.city cit JOIN c.gearbox g JOIN c.body b")
	Page<CarIndex> findCarIndex(Pageable pageable);
	
}
