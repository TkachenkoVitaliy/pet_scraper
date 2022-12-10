package ru.vtkachenko.pet_scraper.scrap_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.exception.NaNException;
import ru.vtkachenko.pet_scraper.scrap_task.model.PreliminaryTask;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;
import ru.vtkachenko.pet_scraper.scrap_task.service.ScrapTaskService;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
public class ScrapTaskController {
    private final ScrapTaskService scrapTasksService;

    @Autowired
    public ScrapTaskController(ScrapTaskService scrapTasksService) {
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
