package ru.vtkachenko.pet_scraper.contractor.service;

import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.contractor.controller.request.ContractorRequest;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;
import ru.vtkachenko.pet_scraper.contractor.repository.ContractorRepository;

import java.util.List;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;


    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public void saveContractor(ContractorRequest contractorRequest) {
        Contractor contractor = new Contractor();
        contractor.setId(contractorRequest.getId() != null ? contractorRequest.getId() : null);
        contractor.setName(contractorRequest.getName() != null ? contractorRequest.getName() : null);
        contractor.setInn(contractorRequest.getInn() != null ? contractorRequest.getInn() : null);
        contractor.setActive(contractorRequest.isActive() != null ? contractorRequest.isActive() : true);

        contractorRepository.save(contractor);
    }

    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    public void updateContractor(ContractorRequest contractorRequest) throws NotFoundObjectException {
        findById(contractorRequest.getId());
        saveContractor(contractorRequest);
    }
    public Contractor findById(Long id) throws NotFoundObjectException {
        return contractorRepository.findById(id)
                .orElseThrow(() -> new NotFoundObjectException("Не удалось найти контрагента"));
    }
}
