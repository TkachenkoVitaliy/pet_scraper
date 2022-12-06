package ru.vtkachenko.pet_scraper.contoller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vtkachenko.pet_scraper.contoller.request.CityRequest;
import ru.vtkachenko.pet_scraper.service.CityService;

@RestController
@CrossOrigin(origins = "*")
public class CityController {

    private final CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @PostMapping("/cities")
    public String createCity(@RequestBody CityRequest cityRequest){
        service.saveCity(cityRequest);

        return "OK";
    }
}
