package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer>{

	Currency findByName(String name);
}
