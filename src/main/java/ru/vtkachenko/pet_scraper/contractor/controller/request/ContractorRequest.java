package ru.vtkachenko.pet_scraper.contractor.controller.request;


public class ContractorRequest {

    private Long id;

    private String name;

    private String inn;

    private Boolean isActive;

    public ContractorRequest() {
    }

    public ContractorRequest(Long id, String name, String inn, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.inn = inn;
        this.isActive = isActive;
    }

    public ContractorRequest(String name, String inn) {
        this.name = name;
        this.inn = inn;
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

    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }


}
