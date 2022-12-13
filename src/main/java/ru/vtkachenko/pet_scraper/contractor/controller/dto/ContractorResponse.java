package ru.vtkachenko.pet_scraper.contractor.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractorResponse {
    private Long id;
    private String name;
}
