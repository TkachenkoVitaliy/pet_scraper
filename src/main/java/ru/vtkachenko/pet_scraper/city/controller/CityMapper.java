package ru.vtkachenko.pet_scraper.city.controller;

import org.springframework.stereotype.Component;
import ru.vtkachenko.pet_scraper.city.controller.dto.CityRequest;
import ru.vtkachenko.pet_scraper.city.controller.dto.CityResponse;
import ru.vtkachenko.pet_scraper.city.model.City;

@Component
public class CityMapper {

    public City mapToEntity(CityRequest cityRequest) {
        return City.builder()
                .id(cityRequest.getId())
                .name(cityRequest.getName())
                .shortName(cityRequest.getShortName())
                .build();
    }

    public CityResponse mapFromEntity(City city) {
        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .shortName(city.getShortName())
                .build();
    }
}
