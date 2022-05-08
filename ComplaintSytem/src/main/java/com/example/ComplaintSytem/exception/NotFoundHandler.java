package com.example.ComplaintSytem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
@ControllerAdvice
public class NotFoundHandler {
@ExceptionHandler(value = NotFound.class)
    public ResponseEntity<Object> handleApiException(NotFound e){
        NotfoundException notfoundException=new NotfoundException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());
        return  new ResponseEntity<>(notfoundException, HttpStatus.BAD_REQUEST);
    }
}
