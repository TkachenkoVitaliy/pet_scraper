package ru.vtkachenko.pet_scraper.scrap_task.controller.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResultResponse {
    private String result;
    private LocalDateTime completedAt;
}
