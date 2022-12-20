package ru.vtkachenko.pet_scraper.task_result.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.task_result.model.TaskResult;

@Repository
public interface TaskResultRepository extends JpaRepository<TaskResult, Long> {
}
