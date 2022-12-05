package ru.vtkachenko.pet_scraper.service;

import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.contoller.request.CityRequest;
import ru.vtkachenko.pet_scraper.model.City;
import ru.vtkachenko.pet_scraper.repository.CityRepository;

@Service
public class CityService {
    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public void saveCity(CityRequest request) {
        repository.save(new City(request.getName(), request.getShortName()));
    }
}
