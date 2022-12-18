package ru.vtkachenko.pet_scraper.task_result.model;

import lombok.*;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks_result")
public class TaskResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "scrap_task_id")
    private ScrapTask scrapTask;

    private Integer result;

    private LocalDate completedDate;

    private LocalTime completedTime;

    private LocalDateTime completedAt;
}
