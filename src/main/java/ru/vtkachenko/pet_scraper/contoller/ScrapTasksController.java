package ru.vtkachenko.pet_scraper.contoller;

import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.exception.NaNException;
import ru.vtkachenko.pet_scraper.model.PreliminaryTask;
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
    public String runScrapTask (@RequestBody PreliminaryTask preliminaryTask) throws IOException {
        return scrapTasksService.runPreliminaryTask(preliminaryTask);
    }

    @PostMapping("/test2")
    public int runScrapTask (@RequestBody ScrapTask scrapTask) throws IOException, NaNException {
        return scrapTasksService.runScrapTask(scrapTask);
    }


}
