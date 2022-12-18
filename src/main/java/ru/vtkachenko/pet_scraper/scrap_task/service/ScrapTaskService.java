package ru.vtkachenko.pet_scraper.scrap_task.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vtkachenko.pet_scraper.exception.service.NaNException;
import ru.vtkachenko.pet_scraper.exception.api.NotFoundObjectException;
import ru.vtkachenko.pet_scraper.scrap_task.model.PreliminaryTask;
import ru.vtkachenko.pet_scraper.scrap_task.model.ScrapTask;
import ru.vtkachenko.pet_scraper.scrap_task.repository.ScrapTaskRepository;

import java.io.IOException;
import java.util.List;

@Service
public class ScrapTaskService {

    private final ScrapTaskRepository scrapTaskRepository;

    @Autowired
    public ScrapTaskService(ScrapTaskRepository scrapTaskRepository) {
        this.scrapTaskRepository = scrapTaskRepository;
    }

    public List<ScrapTask> getAllScrapTasks() {
        return scrapTaskRepository.findAll();
    }

    public ScrapTask getScrapTaskById(Long id) throws NotFoundObjectException {
        return scrapTaskRepository.findById(id).orElseThrow(() -> new NotFoundObjectException("задачу", id));
    }

    public ScrapTask saveScrapTask(ScrapTask scrapTask) {
        return scrapTaskRepository.save(scrapTask);
    }

    public ScrapTask updateScrapTask(ScrapTask scrapTask) throws NotFoundObjectException {
        ScrapTask scrapTaskFromDb = getScrapTaskById(scrapTask.getId());
        return saveScrapTask(scrapTask);
    }

    public void deleteScrapTask(Long id) throws NotFoundObjectException {
        ScrapTask scrapTask = getScrapTaskById(id);
        scrapTaskRepository.deleteById(id);
    }

//    Refactor


    public int runScrapTask(Long id) throws IOException, NaNException, NotFoundObjectException {
        ScrapTask scrapTask = getScrapTaskById(id);

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
