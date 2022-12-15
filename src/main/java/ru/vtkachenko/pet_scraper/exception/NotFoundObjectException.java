package ru.vtkachenko.pet_scraper.exception;

public class NotFoundObjectException extends Exception{
    public NotFoundObjectException(String objectName, Long identifier) {
        super("Не удалось найти " + objectName + " с идентификатором - " + identifier.toString());
    }

    public NotFoundObjectException(String objectName, String field, String fieldValue) {
        super("Не удалось найти " + objectName + " с " + field + " - " + fieldValue);
    }
}
