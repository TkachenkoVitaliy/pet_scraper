package ru.vtkachenko.pet_scraper.exception.api;

import lombok.Getter;

@Getter
public class NotFoundObjectException extends Exception{
    private final String title = "Ресурс не найден";

    public NotFoundObjectException(String objectName, Long identifier) {
        super("Не удалось найти " + objectName + " с идентификатором - " + identifier.toString());
    }

    public NotFoundObjectException(String objectName, String field, String fieldValue) {
        super("Не удалось найти " + objectName + " с " + field + " - " + fieldValue);
    }
}
