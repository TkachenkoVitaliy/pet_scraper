package ru.vtkachenko.pet_scraper.task_result.service;

import ru.vtkachenko.pet_scraper.task_result.repository.TaskResultRepository;

public class TaskResultService {

    private final TaskResultRepository taskResultRepository;

    public TaskResultService(TaskResultRepository taskResultRepository) {
        this.taskResultRepository = taskResultRepository;
    }


}
