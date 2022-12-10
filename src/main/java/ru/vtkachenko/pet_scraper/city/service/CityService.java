package ru.vtkachenko.pet_scraper.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.city.controller.request.CityRequest;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.city.model.City;
import ru.vtkachenko.pet_scraper.city.repository.CityRepository;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void saveCity(CityRequest cityRequest) {
        City city = new City();
        city.setId(cityRequest.getId() != null ? cityRequest.getId() : null);
        city.setName(cityRequest.getName() != null ? cityRequest.getName() : null);
        city.setShortName(cityRequest.getShortName() != null ? cityRequest.getShortName() : city.getName());

        cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public void updateCity(CityRequest cityRequest) throws NotFoundObjectException {
        findById(cityRequest.getId());
        saveCity(cityRequest);
    }
    public City findById(Long id) throws NotFoundObjectException {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("Не удалось найти город"));
    }
}
