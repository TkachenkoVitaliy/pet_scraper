package ru.vtkachenko.pet_scraper.scrap_task.model;

public class PreliminaryTask {

    private String url;

    private String[] selectors;

    public PreliminaryTask() {
    }

    public PreliminaryTask(String url, String[] selectors) {
        this.url = url;
        this.selectors = selectors;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getSelectors() {
        return selectors;
    }

    public void setSelectors(String[] selectors) {
        this.selectors = selectors;
    }
}
