package ru.vtkachenko.pet_scraper.scrap_task.controller;

import org.springframework.stereotype.Component;
import ru.vtkachenko.pet_scraper.scrap_task.controller.dto.ScrapTaskRequest;
import ru.vtkachenko.pet_scraper.scrap_task.controller.dto.ScrapTaskResponse;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;

@Component
public class ScrapTaskMapper {
    public ScrapTask mapToEntity(ScrapTaskRequest scrapTaskRequest) {
        return ScrapTask.builder()
                .id(scrapTaskRequest.getId())
                .nomenclature(scrapTaskRequest.getNomenclature())
                .contractor(scrapTaskRequest.getContractor())
                .city(scrapTaskRequest.getCity())
                .url(scrapTaskRequest.getUrl())
                .selectors(scrapTaskRequest.getSelectors())
                .active(scrapTaskRequest.getActive())
                .build();
    }

    public ScrapTaskResponse mapFromEntity(ScrapTask scrapTask) {
        return ScrapTaskResponse.builder()
                .id(scrapTask.getId())
                .nomenclature(scrapTask.getNomenclature())
                .contractor(scrapTask.getContractor())
                .city(scrapTask.getCity())
                .url(scrapTask.getUrl())
                .selectors(scrapTask.getSelectors())
                .active(scrapTask.getActive())
                .build();
    }
}
