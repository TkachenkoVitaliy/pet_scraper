package ru.vtkachenko.pet_scraper.exception.service;

public class NaNException extends Exception {
    public NaNException(String message) {
        super(message + "\n не является числом");
    }
}
