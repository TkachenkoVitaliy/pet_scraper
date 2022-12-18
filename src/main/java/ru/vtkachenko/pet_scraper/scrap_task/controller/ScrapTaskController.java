package ru.vtkachenko.pet_scraper.scrap_task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.exception.api.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.scrap_task.controller.dto.ScrapTaskRequest;
import ru.vtkachenko.pet_scraper.scrap_task.controller.dto.ScrapTaskResponse;
import ru.vtkachenko.pet_scraper.scrap_task.controller.dto.TaskResultResponse;
import ru.vtkachenko.pet_scraper.scrap_task.model.PreliminaryTask;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;
import ru.vtkachenko.pet_scraper.scrap_task.service.ScrapTaskService;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.List;

@RestController("/api/v1/scrap-tasks")
@CrossOrigin(origins = "*")
public class ScrapTaskController {
    private final ScrapTaskService scrapTasksService;
    private final ScrapTaskMapper scrapTaskMapper;

    private final Clock clock;

    @Autowired
    public ScrapTaskController(ScrapTaskService scrapTasksService, ScrapTaskMapper scrapTaskMapper, Clock clock) {
        this.scrapTasksService = scrapTasksService;
        this.scrapTaskMapper = scrapTaskMapper;
        this.clock = clock;
    }

    @PostMapping
    public ResponseEntity<ScrapTaskResponse> createScrapTask(@RequestBody ScrapTaskRequest scrapTaskRequest) {
        ScrapTask scrapTask = scrapTaskMapper.mapToEntity(scrapTaskRequest);
        ScrapTaskResponse scrapTaskResponse = scrapTaskMapper.mapFromEntity(scrapTasksService.saveScrapTask(scrapTask));

        return ResponseEntity.status(HttpStatus.CREATED).body(scrapTaskResponse);
    }

    @PutMapping
    public ResponseEntity<ScrapTaskResponse> updateScrapTask(@RequestBody ScrapTaskRequest scrapTaskRequest) throws NotFoundObjectException {
        ScrapTask scrapTask = scrapTaskMapper.mapToEntity(scrapTaskRequest);
        ScrapTaskResponse scrapTaskResponse = scrapTaskMapper.mapFromEntity(
                scrapTasksService.updateScrapTask(scrapTask)
        );

        return ResponseEntity.status(HttpStatus.OK).body(scrapTaskResponse);
    }

    @GetMapping
    public ResponseEntity<List<ScrapTaskResponse>> getAllScrapTasks() {
        List<ScrapTask> scrapTasks = scrapTasksService.getAllScrapTasks();
        List<ScrapTaskResponse> scrapTasksResponse = scrapTasks.stream()
                .map(scrapTaskMapper::mapFromEntity)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(scrapTasksResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScrapTaskResponse> getScrapTask(@PathVariable Long id) throws NotFoundObjectException {
        ScrapTask scrapTask = scrapTasksService.getScrapTaskById(id);
        ScrapTaskResponse scrapTaskResponse = scrapTaskMapper.mapFromEntity(scrapTask);

        return ResponseEntity.status(HttpStatus.OK).body(scrapTaskResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteScrapTask(@PathVariable Long id) throws NotFoundObjectException {
        scrapTasksService.deleteScrapTask(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/run")
    public ResponseEntity<TaskResultResponse> runScrapTask (@RequestBody PreliminaryTask preliminaryTask) throws IOException {
        String result = scrapTasksService.runPreliminaryTask(preliminaryTask);
        LocalDateTime completedAt = LocalDateTime.now(clock);

        return ResponseEntity.status(HttpStatus.OK)
                .body(
                        TaskResultResponse.builder()
                        .result(result)
                        .completedAt(completedAt)
                        .build()
                );
    }
}
