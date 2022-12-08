package ru.vtkachenko.pet_scraper.contoller.request;

public class CityRequest {

    private Long id;
    private String name;

    private String shortName;

    public CityRequest(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public CityRequest(String name) {
        this.name = name;
        this.shortName = name;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
