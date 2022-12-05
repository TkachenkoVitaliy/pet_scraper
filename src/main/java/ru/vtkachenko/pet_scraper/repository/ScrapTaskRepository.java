package ru.vtkachenko.pet_scraper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.model.ScrapTask;

@Repository
public interface ScrapTaskRepository extends JpaRepository<ScrapTask, Long> {
}
