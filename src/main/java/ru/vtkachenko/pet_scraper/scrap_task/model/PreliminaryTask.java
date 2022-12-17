package ru.vtkachenko.pet_scraper.scrap_task.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PreliminaryTask {
    private String url;
    private String[] selectors;
}
