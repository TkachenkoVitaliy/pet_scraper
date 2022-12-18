package ru.vtkachenko.pet_scraper.scrap_task.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PreliminaryTask {
    private String url;
    private String[] selectors;
}
