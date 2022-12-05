package ru.vtkachenko.pet_scraper.contoller.request;

public class CityRequest {
    private String name;

    private String shortName;

    public CityRequest(String name, String shortName) {
        this.name = name;
        this.shortName = shortName;
    }

    public CityRequest(String name) {
        this.name = name;
        this.shortName = name;
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
