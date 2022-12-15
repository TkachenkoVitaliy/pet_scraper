package ru.vtkachenko.pet_scraper.contractor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;
import ru.vtkachenko.pet_scraper.contractor.repository.ContractorRepository;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;

import java.util.List;

@Service
public class ContractorService {

    private final ContractorRepository contractorRepository;

    @Autowired
    public ContractorService(ContractorRepository contractorRepository) {
        this.contractorRepository = contractorRepository;
    }

    public List<Contractor> getAllContractors() {
        return contractorRepository.findAll();
    }

    public Contractor getContractorById(Long id) throws NotFoundObjectException {
        return contractorRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("конкурент", id));
    }

    public Contractor getContractorByName(String name) throws NotFoundObjectException {
        Contractor contractor = contractorRepository.findContractorByName(name);
        if (contractor == null) throw new NotFoundObjectException("конкурент", "названием", name);
        return contractor;
    }

    public Contractor saveContractor(Contractor contractor) {
        return contractorRepository.save(contractor);
    }

    public Contractor updateContractor(Contractor contractor) throws NotFoundObjectException {
        Contractor contractorFromDb = getContractorById(contractor.getId());
        return saveContractor(contractor);
    }

    public void deleteContractor(Long id) throws NotFoundObjectException {
        Contractor contractor = getContractorById(id);
        contractorRepository.deleteById(id);
    }
}
