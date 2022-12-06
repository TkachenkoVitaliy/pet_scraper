package ru.vtkachenko.pet_scraper.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.model.ScrapTask;

import java.io.IOException;
import java.util.Arrays;

@Service
public class ScrapTasksService {

    public String runTask(ScrapTask task) throws IOException {
        Document doc = Jsoup.connect(task.getUrl()).get();
        Elements elements = doc.select("body");

        Elements finalElements = Arrays.stream(task.getSelectors())
                .reduce(elements, (partialElements, item) -> partialElements.select(item), (first, second) -> second);

        if (finalElements.size() == 1) {
            return finalElements.first().toString();
        }

        return "fail";
    }
}
