package ru.vtkachenko.pet_scraper.contractor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ru.vtkachenko.pet_scraper.contractor.service.ContractorService;

@RestController
@CrossOrigin(origins = "*")
public class ContractorController {

    private final ContractorService contractorService;

    @Autowired
    public ContractorController(ContractorService contractorService) {
        this.contractorService = contractorService;
    }
}
