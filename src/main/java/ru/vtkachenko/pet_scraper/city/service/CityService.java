package ru.vtkachenko.pet_scraper.city.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City getCityById(Long id) throws NotFoundObjectException {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("город", id.toString()));
    }

    public City getCityByName(String name) {
        return cityRepository.findCityByName(name);
    }

    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(City city) throws NotFoundObjectException {
        City cityFromDb = getCityById(city.getId());
        return saveCity(city);
    }

    public void deleteCity(Long id) throws NotFoundObjectException {
        //TODO подумать как правильно поступать в таком случае, явно напарываться на ошибку или нет
        City city = getCityById(id);
        cityRepository.deleteById(id);
    }


}
