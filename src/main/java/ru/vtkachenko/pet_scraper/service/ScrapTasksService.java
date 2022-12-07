package ru.vtkachenko.pet_scraper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.exception.NaNException;
import ru.vtkachenko.pet_scraper.model.PreliminaryTask;
import ru.vtkachenko.pet_scraper.model.ScrapTask;

import java.io.IOException;

@Service
public class ScrapTasksService {

    public int runScrapTask(ScrapTask task) throws IOException, NaNException {
        int result = 0;
        String textResult = runPreliminaryTask(task);

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
