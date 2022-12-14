package ru.vtkachenko.pet_scraper.task_result.model;

import lombok.*;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    private LocalDateTime completedAt;
}
