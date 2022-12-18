package ru.vtkachenko.pet_scraper.nomenclature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.exception.api.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.nomenclature.model.Nomenclature;
import ru.vtkachenko.pet_scraper.nomenclature.repository.NomenclatureRepository;

import java.util.List;

@Service
public class NomenclatureService {

    private final NomenclatureRepository nomenclatureRepository;

    @Autowired
    public NomenclatureService(NomenclatureRepository nomenclatureRepository) {
        this.nomenclatureRepository = nomenclatureRepository;
    }

    public List<Nomenclature> getAllNomenclatures() {
        return nomenclatureRepository.findAll();
    }

    public Nomenclature getNomenclatureById(Long id) throws NotFoundObjectException {
        return nomenclatureRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("номенклатуру", id));
    }

    public Nomenclature getNomenclatureByName(String name) throws NotFoundObjectException {
        Nomenclature nomenclature = nomenclatureRepository.findNomenclatureByName(name);
        if (nomenclature == null) throw new NotFoundObjectException("номенклатуру", "с названием", name);
        return nomenclature;
    }

    public Nomenclature saveNomenclature(Nomenclature nomenclature) {
        return nomenclatureRepository.save(nomenclature);
    }

    public Nomenclature updateNomenclature(Nomenclature nomenclature) throws NotFoundObjectException {
        Nomenclature nomenclatureFromDb = getNomenclatureById(nomenclature.getId());
        return saveNomenclature(nomenclature);
    }

    public void deleteNomenclature(Long id) throws NotFoundObjectException {
        Nomenclature nomenclature = getNomenclatureById(id);
        nomenclatureRepository.deleteById(id);
    }
}
