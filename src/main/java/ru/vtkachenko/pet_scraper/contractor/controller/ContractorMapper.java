package ru.vtkachenko.pet_scraper.contractor.controller;

import org.springframework.stereotype.Component;
import ru.vtkachenko.pet_scraper.city.controller.dto.CityRequest;
import ru.vtkachenko.pet_scraper.city.controller.dto.CityResponse;
import ru.vtkachenko.pet_scraper.city.model.City;
import ru.vtkachenko.pet_scraper.contractor.controller.dto.ContractorRequest;
import ru.vtkachenko.pet_scraper.contractor.controller.dto.ContractorResponse;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;

@Component
public class ContractorMapper {
    public Contractor mapToEntity(ContractorRequest contractorRequest) {
        return Contractor.builder()
                .id(contractorRequest.getId())
                .name(contractorRequest.getName())
                .build();
    }

    public ContractorResponse mapFromEntity(Contractor contractor) {
        return ContractorResponse.builder()
                .id(contractor.getId())
                .name(contractor.getName())
                .build();
    }
}
