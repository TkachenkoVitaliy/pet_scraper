package ru.vtkachenko.pet_scraper.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.city.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    public City findCityByName(String name);
}
