package ru.vtkachenko.pet_scraper.contoller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ScrapTasksController {

    @GetMapping("/test")
    public String testMapping() {
        return "TEST COMPLETED";
    }
}
