package ru.vtkachenko.pet_scraper.nomenclature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ru.vtkachenko.pet_scraper.nomenclature.service.NomenclatureService;

@RestController
@CrossOrigin(origins = "*")
public class NomenclatureController {

    private final NomenclatureService nomenclatureService;

    @Autowired
    public NomenclatureController(NomenclatureService nomenclatureService) {
        this.nomenclatureService = nomenclatureService;
    }
}
