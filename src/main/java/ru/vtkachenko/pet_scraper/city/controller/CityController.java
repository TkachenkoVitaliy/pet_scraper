package ru.vtkachenko.pet_scraper.city.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.city.controller.dto.CityRequest;
import ru.vtkachenko.pet_scraper.city.controller.dto.CityResponse;
import ru.vtkachenko.pet_scraper.city.model.City;
import ru.vtkachenko.pet_scraper.city.service.CityService;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class CityController {

    private final CityService cityService;
    private final CityMapper cityMapper;

    @Autowired
    public CityController(CityService cityService, CityMapper cityMapper) {
        this.cityService = cityService;
        this.cityMapper = cityMapper;
    }

    @PostMapping("/cities")
    public ResponseEntity<CityResponse> createCity(@RequestBody CityRequest cityRequest) {
        City city = cityMapper.mapToEntity(cityRequest);
        CityResponse cityResponse = cityMapper.mapFromEntity(cityService.saveCity(city));

        return ResponseEntity.status(HttpStatus.CREATED).body(cityResponse);
    }

    @GetMapping("/cities")
    public ResponseEntity<List<CityResponse>> getAllCity() {
        List<City> cities = cityService.getAllCities();
        List<CityResponse> citiesResponse = cities.stream()
                .map(cityMapper::mapFromEntity)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(citiesResponse);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<CityResponse> getCity(@PathVariable Long id) throws NotFoundObjectException {
        // TODO придумать как отдавать на клиента обработанные ошибки
        City city = cityService.getCityById(id);
        CityResponse cityResponse = cityMapper.mapFromEntity(city);

        return ResponseEntity.status(HttpStatus.OK).body(cityResponse);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity deleteCity(@PathVariable Long id) throws NotFoundObjectException {
        cityService.deleteCity(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
