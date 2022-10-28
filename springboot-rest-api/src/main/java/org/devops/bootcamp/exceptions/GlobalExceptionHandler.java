package org.devops.bootcamp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorMessageList = new ArrayList<>();
        errorMessageList.add(ex.getMessage());

        final String errorMessage = "Malformed JSON request";
        ErrorResponse errorResponse = new ErrorResponse(errorMessage, HttpStatus.BAD_REQUEST, errorMessageList);

        return ResponseEntityBuilder.build(errorResponse);
    }

    protected ResponseEntity<Object> handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errorMessageList = new ArrayList<>();

        errorMessageList.add(ex.getParameterName() + " parameter is missing");

//        errorMessageList.add(ex.getMessage());
        final String errorMessage = "Validation Errors";

        ErrorResponse errorResponse = new ErrorResponse(errorMessage, HttpStatus.BAD_REQUEST, errorMessageList);

        headers.add("error", errorMessage);
        return ResponseEntityBuilder.build(errorResponse);
    }

    @ExceptionHandler(NoSuchElementFoundException.class)
    public ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementFoundException ex) {
        List<String> errorMessageList = new ArrayList<>();

        errorMessageList.add(ex.getMessage());

        final String errorMessage = "Element not found";

        ErrorResponse errorResponse = new ErrorResponse(errorMessage, HttpStatus.NOT_FOUND, errorMessageList);

        return ResponseEntityBuilder.build(errorResponse);
    }

}
