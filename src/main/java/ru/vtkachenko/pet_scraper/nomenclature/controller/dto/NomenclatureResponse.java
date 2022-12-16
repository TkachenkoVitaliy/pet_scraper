package ru.vtkachenko.pet_scraper.nomenclature.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NomenclatureResponse {
    private Long id;
    private String name;
}
