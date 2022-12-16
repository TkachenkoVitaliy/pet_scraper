package ru.vtkachenko.pet_scraper.nomenclature.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NomenclatureRequest {
    private Long id;
    private String name;
}
