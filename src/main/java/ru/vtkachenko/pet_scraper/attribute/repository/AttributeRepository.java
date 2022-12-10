package ru.vtkachenko.pet_scraper.attribute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.attribute.model.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}
