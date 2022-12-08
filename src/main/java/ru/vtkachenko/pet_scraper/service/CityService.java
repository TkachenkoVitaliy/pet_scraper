package ru.vtkachenko.pet_scraper.service;

import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.contoller.request.CityRequest;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.model.City;
import ru.vtkachenko.pet_scraper.repository.CityRepository;

import java.util.List;

@Service
public class CityService {
    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public void saveCity(CityRequest cityRequest) {
        City city = new City();
        city.setId(cityRequest.getId() != null ? cityRequest.getId() : null);
        city.setName(cityRequest.getName() != null ? cityRequest.getName() : null);
        city.setShortName(cityRequest.getShortName() != null ? cityRequest.getShortName() : city.getName());

        repository.save(city);
    }

    public List<City> getAllCities() {
        return repository.findAll();
    }

    public void updateCity(CityRequest cityRequest) throws NotFoundObjectException {
        findById(cityRequest.getId());
        saveCity(cityRequest);
    }
    public City findById(Long id) throws NotFoundObjectException {
        return repository.findById(id).orElseThrow(() -> new NotFoundObjectException("Не удалось найти город"));
    }
}
