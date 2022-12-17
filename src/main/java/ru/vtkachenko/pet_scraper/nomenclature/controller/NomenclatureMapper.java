package ru.vtkachenko.pet_scraper.nomenclature.controller;

import org.springframework.stereotype.Component;
import ru.vtkachenko.pet_scraper.nomenclature.controller.dto.NomenclatureRequest;
import ru.vtkachenko.pet_scraper.nomenclature.controller.dto.NomenclatureResponse;
import ru.vtkachenko.pet_scraper.nomenclature.model.Nomenclature;

@Component
public class NomenclatureMapper {

    public Nomenclature mapToEntity(NomenclatureRequest nomenclatureRequest) {
        return Nomenclature.builder()
                .id(nomenclatureRequest.getId())
                .name(nomenclatureRequest.getName())
                .build();
    }

    public NomenclatureResponse mapFromEntity(Nomenclature nomenclature) {
        return NomenclatureResponse.builder()
                .id(nomenclature.getId())
                .name(nomenclature.getName())
                .build();
    }
}
