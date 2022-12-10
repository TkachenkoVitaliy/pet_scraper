package ru.vtkachenko.pet_scraper.scrap_task.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.exception.NaNException;
import ru.vtkachenko.pet_scraper.scrap_task.model.PreliminaryTask;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;
import ru.vtkachenko.pet_scraper.scrap_task.repository.ScrapTaskRepository;

import java.io.IOException;

@Service
public class ScrapTaskService {

    private final ScrapTaskRepository repository;

    @Autowired
    public ScrapTaskService(ScrapTaskRepository repository) {
        this.repository = repository;
    }

    public void saveScrapTask(ScrapTask scrapTask) {
        repository.save(scrapTask);
    }

    public int runScrapTask(ScrapTask scrapTask) throws IOException, NaNException {
        saveScrapTask(scrapTask);

        int result = 0;
        String textResult = runPreliminaryTask(scrapTask);

        try {
            result = Integer.parseInt(textResult.replaceAll(" ", ""));
        } catch (NumberFormatException e) {
            throw new NaNException(textResult);
        }
        return result;
    }

    public String runPreliminaryTask(PreliminaryTask task) throws IOException {
        Document doc = Jsoup.connect(task.getUrl()).get();
        Elements elements = doc.select("body");

        for(String selector: task.getSelectors()) {
            if (selector.equals("END")) {
                return elements.text();
            }
            elements = elements.select(selector);
            if (elements.size() == 0) {
                return "Неудалось найти элементов с селектором - " + selector;
            }
        }

        return elements.toString();
    }
}
