package ru.vtkachenko.pet_scraper.contractor.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "contractors")
public class Contractor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String inn;

    @Column(name = "is_active")
    private boolean isActive;

    public Contractor() {
    }

    public Contractor(String name, String inn, boolean isActive) {
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
