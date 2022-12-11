package ru.vtkachenko.pet_scraper.exception;

public class NotFoundObjectException extends Exception{
    public NotFoundObjectException(String objectName, String identifier) {
        super("Не удалось найти " + objectName + " с идентификатором - " + identifier);
    }
}
