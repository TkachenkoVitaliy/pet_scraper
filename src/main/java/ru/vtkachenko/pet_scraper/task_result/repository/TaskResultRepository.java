package ru.vtkachenko.pet_scraper.task_result.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;
import ru.vtkachenko.pet_scraper.task_result.model.TaskResult;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TaskResultRepository extends JpaRepository<TaskResult, Long> {

    Optional<TaskResult> findTaskResultByScrapTaskAndCompletedAt_Date(ScrapTask scrapTask, LocalDate date);
}
