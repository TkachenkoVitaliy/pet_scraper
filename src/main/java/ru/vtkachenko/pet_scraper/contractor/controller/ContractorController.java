package ru.vtkachenko.pet_scraper.contractor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.contractor.controller.dto.ContractorRequest;
import ru.vtkachenko.pet_scraper.contractor.controller.dto.ContractorResponse;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;
import ru.vtkachenko.pet_scraper.contractor.service.ContractorService;
import ru.vtkachenko.pet_scraper.exception.api.NotFoundObjectException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contractors")
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

    @PutMapping
    public ResponseEntity<ContractorResponse> updateContractor(@RequestBody ContractorRequest contractorRequest) throws NotFoundObjectException {
        Contractor contractor = contractorMapper.mapToEntity(contractorRequest);
        ContractorResponse contractorResponse = contractorMapper.mapFromEntity(contractorService.updateContractor(contractor));

        return ResponseEntity.status(HttpStatus.OK).body(contractorResponse);
    }

    @GetMapping
    public ResponseEntity<List<ContractorResponse>> getAllContractors() {
        List<Contractor> contractors = contractorService.getAllContractors();
        List<ContractorResponse> contractorsResponse = contractors.stream().
                map(contractorMapper::mapFromEntity)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(contractorsResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContractorResponse> getContractor(@PathVariable Long id) throws NotFoundObjectException {
        Contractor contractor = contractorService.getContractorById(id);
        ContractorResponse contractorResponse = contractorMapper.mapFromEntity(contractor);

        return ResponseEntity.status(HttpStatus.OK).body(contractorResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContractor(@PathVariable Long id) throws NotFoundObjectException {
        contractorService.deleteContractor(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
