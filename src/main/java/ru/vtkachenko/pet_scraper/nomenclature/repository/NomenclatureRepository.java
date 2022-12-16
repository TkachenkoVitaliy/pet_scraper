package ru.vtkachenko.pet_scraper.nomenclature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vtkachenko.pet_scraper.nomenclature.model.Nomenclature;

@Repository
public interface NomenclatureRepository extends JpaRepository<Nomenclature, Long> {

    public Nomenclature findNomenclatureByName(String name);
}
