package ru.vtkachenko.pet_scraper.contoller;

import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.model.ScrapTask;
import ru.vtkachenko.pet_scraper.service.ScrapTasksService;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class ScrapTasksController {
    private final ScrapTasksService scrapTasksService;

    public ScrapTasksController(ScrapTasksService scrapTasksService) {
        this.scrapTasksService = scrapTasksService;
    }

    @GetMapping("/test")
    public String testMapping() {
        return "TEST COMPLETED";
    }

    @PostMapping("/test")
    public String runScrapTask (@RequestBody ScrapTask scrapTask) throws IOException {
        return scrapTasksService.runTask(scrapTask);
    }


}
