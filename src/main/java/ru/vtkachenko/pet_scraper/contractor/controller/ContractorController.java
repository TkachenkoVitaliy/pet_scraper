package ru.vtkachenko.pet_scraper.contractor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vtkachenko.pet_scraper.contractor.controller.dto.ContractorRequest;
import ru.vtkachenko.pet_scraper.contractor.controller.dto.ContractorResponse;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;
import ru.vtkachenko.pet_scraper.contractor.service.ContractorService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ContractorController {

    private final ContractorService contractorService;
    private final ContractorMapper contractorMapper;

    @Autowired
    public ContractorController(ContractorService contractorService, ContractorMapper contractorMapper) {
        this.contractorService = contractorService;
        this.contractorMapper = contractorMapper;
    }

    @PostMapping
    public ResponseEntity<ContractorResponse> createContractor(@RequestBody ContractorRequest contractorRequest) {
        Contractor contractor = contractorMapper.mapToEntity(contractorRequest);
        ContractorResponse contractorResponse = contractorMapper.mapFromEntity(contractorService.saveContractor(contractor));

        return ResponseEntity.status(HttpStatus.CREATED).body(contractorResponse);
    }
}
