package ru.vtkachenko.pet_scraper.attribute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import ru.vtkachenko.pet_scraper.attribute.service.AttributeService;

@RestController
@CrossOrigin(origins = "*")
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }
}
