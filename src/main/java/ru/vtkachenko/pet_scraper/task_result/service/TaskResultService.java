package ru.vtkachenko.pet_scraper.task_result.service;

import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.exception.service.NaNException;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;
import ru.vtkachenko.pet_scraper.scrap_task.service.ScrapTaskService;
import ru.vtkachenko.pet_scraper.task_result.model.TaskResult;
import ru.vtkachenko.pet_scraper.task_result.repository.TaskResultRepository;

import java.io.IOException;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TaskResultService {

    private final TaskResultRepository taskResultRepository;
    private final ScrapTaskService scrapTaskService;
    private final Clock clock;

    public TaskResultService(TaskResultRepository taskResultRepository, ScrapTaskService scrapTaskService, Clock clock) {
        this.taskResultRepository = taskResultRepository;
        this.scrapTaskService = scrapTaskService;
        this.clock = clock;
    }

    private void saveCompletedTask(TaskResult taskResult) {
        Optional<TaskResult> taskResultFromDb = taskResultRepository.findTaskResultByScrapTaskAndCompletedAt_Date(
                taskResult.getScrapTask(),
                taskResult.getCompletedAt().toLocalDate()
        );

        taskResultFromDb.ifPresent(result -> taskResult.setId(result.getId()));

        taskResultRepository.save(taskResult);
    }

    private TaskResult runTask(ScrapTask scrapTask) throws IOException, NaNException {
        return TaskResult.builder()
                .scrapTask(scrapTask)
                .result(scrapTaskService.runScrapTask(scrapTask))
                .completedAt(LocalDateTime.now(clock))
                .build();
    }


}
