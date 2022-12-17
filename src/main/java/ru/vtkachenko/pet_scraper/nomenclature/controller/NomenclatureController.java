package ru.vtkachenko.pet_scraper.nomenclature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vtkachenko.pet_scraper.exception.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.nomenclature.controller.dto.NomenclatureRequest;
import ru.vtkachenko.pet_scraper.nomenclature.controller.dto.NomenclatureResponse;
import ru.vtkachenko.pet_scraper.nomenclature.model.Nomenclature;
import ru.vtkachenko.pet_scraper.nomenclature.service.NomenclatureService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class NomenclatureController {

    private final NomenclatureService nomenclatureService;

    private final NomenclatureMapper nomenclatureMapper;

    @Autowired
    public NomenclatureController(NomenclatureService nomenclatureService, NomenclatureMapper nomenclatureMapper) {
        this.nomenclatureService = nomenclatureService;
        this.nomenclatureMapper = nomenclatureMapper;
    }

    @PostMapping("/nomenclatures")
    public ResponseEntity<NomenclatureResponse> createNomenclature(@RequestBody NomenclatureRequest nomenclatureRequest) {
        Nomenclature nomenclature = nomenclatureMapper.mapToEntity(nomenclatureRequest);
        NomenclatureResponse nomenclatureResponse = nomenclatureMapper.mapFromEntity(
                nomenclatureService.saveNomenclature(nomenclature)
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(nomenclatureResponse);
    }

    @PutMapping("/nomenclatures")
    public ResponseEntity<NomenclatureResponse> updateNomenclature(@RequestBody NomenclatureRequest nomenclatureRequest) throws NotFoundObjectException {
        Nomenclature nomenclature = nomenclatureMapper.mapToEntity(nomenclatureRequest);
        NomenclatureResponse nomenclatureResponse = nomenclatureMapper.mapFromEntity(
                nomenclatureService.updateNomenclature(nomenclature)
        );

        return ResponseEntity.status(HttpStatus.OK).body(nomenclatureResponse);
    }


    @GetMapping("/nomenclatures")
    public ResponseEntity<List<NomenclatureResponse>> getAllNomenclatures() {
        List<Nomenclature> nomenclatures = nomenclatureService.getAllNomenclatures();
        List<NomenclatureResponse> nomenclaturesResponse = nomenclatures.stream()
                .map(nomenclatureMapper::mapFromEntity)
                .toList();

        return ResponseEntity.status(HttpStatus.OK).body(nomenclaturesResponse);
    }

    @GetMapping("/nomenclatures/{id}")
    public ResponseEntity<NomenclatureResponse> getNomenclature(@PathVariable Long id) throws NotFoundObjectException {
        Nomenclature nomenclature = nomenclatureService.getNomenclatureById(id);
        NomenclatureResponse nomenclatureResponse = nomenclatureMapper.mapFromEntity(nomenclature);

        return ResponseEntity.status(HttpStatus.OK).body(nomenclatureResponse);
    }

    @DeleteMapping("/nomenclatures/{id}")
    public ResponseEntity deleteNomenclature(@PathVariable Long id) throws NotFoundObjectException {
        nomenclatureService.deleteNomenclature(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
