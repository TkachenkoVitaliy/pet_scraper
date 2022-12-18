package ru.vtkachenko.pet_scraper.exception.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundObjectException.class)
    public ResponseEntity<ErrorResponse> notFoundObjectException(NotFoundObjectException exception,
                                                                 HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.builder()
                        .type("/errors/" + exception.getClass())
                        .title(exception.getTitle())
                        .status(HttpStatus.NOT_FOUND.value())
                        .detail(exception.getMessage())
                        .instance(request.getRequestURI())
                        .build());
    }

}
