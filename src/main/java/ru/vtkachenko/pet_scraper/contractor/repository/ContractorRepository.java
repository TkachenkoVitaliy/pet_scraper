package ru.vtkachenko.pet_scraper.contractor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.contractor.model.Contractor;

@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long> {
}
