package ru.vtkachenko.pet_scraper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
