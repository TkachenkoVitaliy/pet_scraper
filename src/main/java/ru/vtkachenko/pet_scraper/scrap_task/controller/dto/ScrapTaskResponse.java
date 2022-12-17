package ru.vtkachenko.pet_scraper.scrap_task.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.vtkachenko.pet_scraper.city.model.City;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;
import ru.vtkachenko.pet_scraper.nomenclature.model.Nomenclature;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScrapTaskResponse {
    private Long id;
    private Nomenclature nomenclature;
    private Contractor contractor;
    private City city;
    private String url;
    private String[] selectors;
    private Boolean active;
}
