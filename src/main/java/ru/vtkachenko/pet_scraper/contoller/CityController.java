package ru.vtkachenko.pet_scraper.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.contoller.request.CityRequest;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.model.City;
import ru.vtkachenko.pet_scraper.service.CityService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/cities")
    public ResponseEntity createCity(@RequestBody CityRequest cityRequest){
        cityService.saveCity(cityRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @PutMapping("/cities")
    public ResponseEntity updateCity(@RequestBody CityRequest cityRequest) {
        if (cityRequest.getId() == null) {
            //TODO придумать унифицированный объект ответа в случае негативного результата
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try {
            cityService.updateCity(cityRequest);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (NotFoundObjectException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
