package ru.vtkachenko.pet_scraper.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks")
public class ScrapTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String competitor;

    //TODO придумать как это нормально реализовать
//    private List<String> selectors;


}
